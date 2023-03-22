package routers

import (
	"github.com/gin-gonic/gin"
	"net/http"
)

type LoginParam struct {
	Username string `json:"username"`
	Password string `json:"password"`
}

func Ping(c *gin.Context) {
	c.JSON(http.StatusOK, "pong")
}
