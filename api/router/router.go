package router

import (
	"api/routers"
	"github.com/gin-gonic/gin"
)

func RegisterRouters(engine *gin.Engine) {
	// 心跳检测API
	engine.GET("/ping", routers.Ping)

	// account
	engine.POST("/login", routers.Login)
	engine.POST("/logout", routers.Logout)
}
