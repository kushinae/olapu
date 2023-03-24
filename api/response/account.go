package response

type Register struct {
	Id string `json:"id"`
}

type Login struct {
	Id          string `json:"id"`
	Nickname    string `json:"nickname"`
	Avatar      string `json:"avatar"`
	AccessToken string `json:"access_token"`
	TokenType   string `json:"token_type"`
}
