export const getCookie = (key: string): string | null => {
  const arr: RegExpMatchArray | null = document.cookie.match(new RegExp(new RegExp(`(^| )${key}=([^;]*)(;|$)`)));
  if (arr && arr.length > 0) {
      return decodeURI(arr[2])
  }
  return null
}