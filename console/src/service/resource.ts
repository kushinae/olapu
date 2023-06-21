import {ICategoryService} from "@/service/interface";
import api from "@/api";
import {ROOT_RESOURCE_PARENT_ID} from "@/commons/constant";
import molecule from "@dtinsight/molecule";
import {getTreeNode} from "@/utils/resource";
import {IFolderTreeNodeProps} from "@dtinsight/molecule/esm/model";
import {GlobalEvent} from "@dtinsight/molecule/esm/common/event";
import {Resource} from "@/api/response";
import {RESOURCE_CATEGORY} from "@/interface";
import {jobTree} from "@/service/job_tree";
import { singleton } from 'tsyringe';

// @ts-ignore
@singleton()
export default class ResourceCategoryService extends GlobalEvent implements ICategoryService {

  private getResourceNodes = async (node: { parent_id: number, name?: string, category: RESOURCE_CATEGORY, }): Promise<Resource[]> => {
    return await api.getResources({ ...node });
  }

  public loadRootFolder = async () => {
    const resourceResources = await this.getResourceNodes({ parent_id: ROOT_RESOURCE_PARENT_ID, category: RESOURCE_CATEGORY.RESOURCE });
    if (!resourceResources || resourceResources.length < 1) {
      return;
    }
    const resourceTreeNode = getTreeNode(resourceResources[0]);
    // 加载根目录数据, 方式没有数据
    resourceTreeNode.children = await this.loadTreeNode(resourceResources[0].id, RESOURCE_CATEGORY.RESOURCE);
    molecule.folderTree.add(resourceTreeNode);

    const jobResources = await this.getResourceNodes({ parent_id: ROOT_RESOURCE_PARENT_ID, category: RESOURCE_CATEGORY.JOB });
    if (!jobResources || jobResources.length < 1) {
      return;
    }
    const jobTreeNode = getTreeNode(jobResources[0]);
    // 加载根目录数据, 方式没有数据
    jobTreeNode.children = await this.loadTreeNode(jobResources[0].id, RESOURCE_CATEGORY.JOB);
    jobTree.add(jobTreeNode);
    jobTree.forceUpdate();
  }

  public loadTreeNode = async (id: number, category: RESOURCE_CATEGORY): Promise<IFolderTreeNodeProps[] | undefined> => {
    const resources = await this.getResourceNodes({ parent_id: id, category});
    if (resources) {
      return resources.map(child => getTreeNode(child));
    }
  };
}