import molecule from "@dtinsight/molecule";
import {IActionBarItemProps} from "@dtinsight/molecule/esm/components";

export interface ResourceProps {
  panel: molecule.model.IActivityBarItem;
  headerToolBar: IActionBarItemProps[];
}