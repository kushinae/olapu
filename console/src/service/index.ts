import ResourceCategoryService from "@/service/resource";
import {container} from "tsyringe";

const resourceCategoryService = container.resolve(ResourceCategoryService);

export {
  resourceCategoryService
}