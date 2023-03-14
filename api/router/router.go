package router

import (
	"api/routers"
	"github.com/gin-gonic/gin"
)

func RegisterRouters(GinEngine *gin.Engine) {
	// 心跳检测API
	GinEngine.GET("/ping", routers.Ping)
}
