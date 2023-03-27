package routers

import (
	"api/bson"
	"api/request"
	olapuHttp "api/response"
	"github.com/gin-gonic/gin"
	"net/http"
	"time"
)

func CreateDirectory(c *gin.Context) {
	createParam := request.CreateDirectoryParam{}
	err := c.BindJSON(&createParam)
	if err != nil {
		c.JSON(http.StatusBadRequest, olapuHttp.ErrorBuilder(olapuHttp.BadRequestError, &olapuHttp.RequestPayloadMissing))
		return
	}

	resource, err := bson.InsertResource(bson.Resource{
		Type:       createParam.Type,
		Name:       createParam.Name,
		ParentId:   createParam.ParentId,
		Content:    createParam.Content,
		Uid:        "",
		CreateTime: time.Now(),
		ModifyTime: time.Now(),
		Deleted:    false,
	})

	c.JSON(http.StatusOK, resource)
}

func ModifyDirectory(c *gin.Context) {
	c.JSON(http.StatusOK, nil)
}

func RemoveDirectory(c *gin.Context) {
	c.JSON(http.StatusOK, nil)
}

func GetDirectory(c *gin.Context) {
	c.JSON(http.StatusOK, nil)
}
