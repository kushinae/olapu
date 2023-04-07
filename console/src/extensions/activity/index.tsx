import molecule from "@dtinsight/molecule";
import { IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";

export const ActivityExtension: IExtension = {
  id: "ActivityExtension",
  name: "Activity Extension",
  activate(extensionContext: IExtensionService): void {
    molecule.activityBar.onClick((id) => {
      console.log(id);
    });
  },
  dispose(extensionContext: IExtensionService): void {
    // ...
  }
}