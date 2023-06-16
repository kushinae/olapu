import molecule from "@dtinsight/molecule";
import { IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";

export const ActivityExtension: IExtension = {
  id: "ActivityExtension",
  name: "Activity Extension",
  activate(extensionContext: IExtensionService): void {
    onClick();
  },
  dispose(extensionContext: IExtensionService): void {
    // ...
  },
}

const onClick = (): void => {
  molecule.activityBar.onClick((id) => {
    molecule.activityBar.setActive(id);
  });
}