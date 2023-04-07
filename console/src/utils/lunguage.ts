import { languages } from '@dtinsight/molecule/esm/monaco';
import { Keywords, Snippets } from "@/utils/completion";

export async function createSQLProposals(
  range: languages.CompletionItem['range']
): Promise<languages.CompletionItem[]> {
  return (await Keywords(range)).concat(Snippets(range));
}

export const registerCompletionItemProvider = (sql: string) => {
  // languages.registerCompletionItemProvider(sql, {
  //   async provideCompletionItems(model, position) {
  //     const word = model.getWordUntilPosition(position);
  //     const range = {
  //       startLineNumber: position.lineNumber,
  //       endLineNumber: position.lineNumber,
  //       startColumn: word.startColumn,
  //       endColumn: word.endColumn,
  //     };
  //     const suggestions = await createSQLProposals(range);
  //     return {
  //       suggestions,
  //     };
  //   },
  // });
}
