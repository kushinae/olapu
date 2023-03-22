package routers

import (
	olapuHttp "api/response"
	"github.com/gin-gonic/gin"
	"net/http"
)

func Login(c *gin.Context) {
	loginParam := LoginParam{}
	err := c.BindJSON(&loginParam)
	if err != nil {
		c.JSON(http.StatusBadRequest, olapuHttp.BadRequest())
		return
	}
	c.JSON(http.StatusOK, loginParam)
}

func Logout(c *gin.Context) {
	c.JSON(http.StatusOK, nil)
}
