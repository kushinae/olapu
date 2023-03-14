package routers

import (
	olapuHttp "api/http"
	"github.com/gin-gonic/gin"
	"net/http"
)

type LoginParam struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

func Ping(c *gin.Context) {
	c.JSON(http.StatusOK, olapuHttp.Ok.WithMessage("pong"))
}
