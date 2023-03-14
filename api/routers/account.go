package routers

import (
	olapuHttp "api/http"
	"github.com/gin-gonic/gin"
	"net/http"
)

func Login(c *gin.Context) {
	loginParam := LoginParam{}
	err := c.BindJSON(&loginParam)
	if err != nil {
		c.JSON(http.StatusBadRequest, olapuHttp.BadRequest.WithError("Missing Required Parameter"))
		return
	}
	c.JSON(http.StatusOK, olapuHttp.Ok.WithData(loginParam))
}
