package routers

import (
	"github.com/gin-gonic/gin"
)

func RegisterRouters(engine *gin.Engine) {

	group := engine.Group("/api")
	// 心跳检测API
	group.GET("/ping", Ping)

	// account
	group.POST("/login", Login)
	group.POST("/logout", Logout)
	group.POST("/register", Register)
}
