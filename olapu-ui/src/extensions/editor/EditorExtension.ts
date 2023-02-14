import { IExtension } from "@dtinsight/molecule/esm/model";
import { languages, editor } from '@dtinsight/molecule/esm/monaco';
import { IExtensionService } from "@dtinsight/molecule/esm/services";

const SUPPORTED_LANGUAGES = ['java', 'sql'] as const;

/*
provideCompletionItems: async (model: editor.ITextModel, position: Position) => {
          const word = model.getWordUntilPosition(position);
          const range = {
            startLineNumber: position.lineNumber,
            endLineNumber: position.lineNumber,
            startColumn: word.startColumn,
            endColumn: word.endColumn,
          };

          const suggestions = new Promise<languages.CompletionItem[]>((resolve, reject) => {
            resolve([]);
          });
          return {
            suggestions,
          };
        }
      })
*/

export async function createSQLProposals(
  range: languages.CompletionItem['range']
): Promise<languages.CompletionItem[]> {
  return new Promise<languages.CompletionItem[]>((resolve, reject) => {
    resolve([
      {
        label: 'class',
        kind: languages.CompletionItemKind.Class,
        insertText: 'class',
        detail: '类',
        range: range
      },
      {
        label: 'public',
        kind: languages.CompletionItemKind.Variable,
        insertText: 'public',
        detail: '权限修饰符',
        range: range
      }
    ])
  });
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