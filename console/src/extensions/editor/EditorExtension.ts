import { IExtension } from "@dtinsight/molecule/esm/model";
import { languages } from '@dtinsight/molecule/esm/monaco';
import { IExtensionService } from "@dtinsight/molecule/esm/services";
import {Keywords, Snippets} from "@/utils/completion";

const SUPPORTED_LANGUAGES = ['java', 'sql'] as const;

export async function createSQLProposals(
  range: languages.CompletionItem['range']
): Promise<languages.CompletionItem[]> {
    return (await Keywords(range)).concat(Snippets(range));
}

export const EditorExtension: IExtension = {
  id: "EditorExtension",
  name: "Editor Extension",
  activate: function (extensionCtx: IExtensionService): void {
    SUPPORTED_LANGUAGES.forEach(sql => {
      languages.registerCompletionItemProvider(sql, {
        async provideCompletionItems(model, position) {
          const word = model.getWordUntilPosition(position);
          const range = {
            startLineNumber: position.lineNumber,
            endLineNumber: position.lineNumber,
            startColumn: word.startColumn,
            endColumn: word.endColumn,
          };

          const suggestions = await createSQLProposals(range);
          return {
            suggestions,
          };
        },
      })
    })
  },
  dispose: function (extensionCtx: IExtensionService): void {

  }
}