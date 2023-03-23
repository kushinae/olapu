package request

type LoginParam struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

type ResisterParam struct {
	Username string `json:"username"`
	Password string `json:"password"`
	Nickname string `json:"nickname"`
}
