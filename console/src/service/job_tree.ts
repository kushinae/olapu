import {FolderTreeService} from '@dtinsight/molecule/esm/services';
import {IResourceCategory, RESOURCE_CATEGORY} from "@/interface";
import {IFolderTreeNodeProps} from "@dtinsight/molecule/esm/model";
import {UniqueId} from "@dtinsight/molecule/esm/common/types";

let jobTree: JobManagerTree;

class JobManagerTree extends FolderTreeService implements IResourceCategory {

  add(data: IFolderTreeNodeProps, id?: UniqueId) {
    super.add(data, id);
    console.log('add', data);
  }

  getCategory(): RESOURCE_CATEGORY {
    return RESOURCE_CATEGORY.JOB;
  }
}

// @ts-ignore
if (!jobTree) {
  jobTree = new JobManagerTree();
}

export {jobTree};
