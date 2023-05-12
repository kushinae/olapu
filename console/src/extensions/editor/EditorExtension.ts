import { IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import { UniqueId } from "@dtinsight/molecule/esm/common/types";
import { registerCompletionItemProvider } from "@/utils/lunguage";
import { SUPPORTED_LANGUAGES } from "@/commons/constant";

export const EditorExtension: IExtension = {
  id: "EditorExtension",
  name: "EditorExtension",
  activate(extensionCtx: IExtensionService): void {
    SUPPORTED_LANGUAGES.forEach(sql => {
      registerCompletionItemProvider(sql);
    })
  },
  dispose(extensionCtx: IExtensionService): void {

  }
}