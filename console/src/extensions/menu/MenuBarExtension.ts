import { IExtension } from "@dtinsight/molecule/esm/model";
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import {molecule} from '@dtinsight/molecule';
import {localize} from "@dtinsight/molecule/esm/i18n";
import {UniqueId} from "@dtinsight/molecule/esm/common/types";

export default class MenuBarExtension implements IExtension {
    id: UniqueId = "MenuBarExtension";
    name: string = "Menu Extension";
    activate (extensionCtx: IExtensionService): void {
        molecule.menuBar.append({
            id: 'menu.createDataSource',
            name: localize('menu.createDataSource', '创建数据源'),
            icon: '',
        }, 'File');

        // 点击事件
        molecule.menuBar.onSelect((menuId: UniqueId) => {
            console.log(menuId);
        })
    }
    dispose (extensionCtx: IExtensionService): void {
        throw new Error('Method not implemented.');
    }
}