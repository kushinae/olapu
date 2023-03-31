package routers

import (
	"api/commons/constant"
	olapuHttp "api/response"
	"api/util"
	"github.com/gin-gonic/gin"
	"net/http"
)

func RegisterRouters(engine *gin.Engine) {

	group := engine.Group("/api")
	// 心跳检测API
	group.GET("/ping", Ping)
	group.POST("/login", Login)
	group.POST("/register", Register)

	group.Use(Authorize())
	group.POST("/logout", Logout)
	group.POST("/resource", CreateResource)
	group.PUT("/resource", ModifyDirectory)
	group.DELETE("/resource", RemoveDirectory)
	group.GET("/resource", GetResource)
}

func Authorize() gin.HandlerFunc {
	return func(c *gin.Context) {
		bearer := c.GetHeader(constant.AuthorizationHeader) // 用户名
		if util.StringIsEmpty(bearer) {
			c.Abort()
			c.JSON(http.StatusUnauthorized, olapuHttp.ErrorBuilder(olapuHttp.Unauthorized, &olapuHttp.UnauthorizedError))
			return
		}
		token := util.Split(bearer, " ")[1]
		if util.StringIsEmpty(token) {
			c.Abort()
			c.JSON(http.StatusUnauthorized, olapuHttp.ErrorBuilder(olapuHttp.Unauthorized, &olapuHttp.UnauthorizedError))
			return
		}

		verifyToken, err := util.VerifyToken(token)
		if err != nil {
			c.Abort()
			c.JSON(http.StatusUnauthorized, olapuHttp.ErrorBuilder(olapuHttp.Unauthorized, &olapuHttp.UnauthorizedError))
			return
		}

		issuer, err := verifyToken.Claims.GetIssuer()
		if err != nil {
			c.Abort()
			c.JSON(http.StatusUnauthorized, olapuHttp.ErrorBuilder(olapuHttp.Unauthorized, &olapuHttp.UnauthorizedError))
			return
		}

		c.Set("uid", issuer)

		c.Next()
	}
}
