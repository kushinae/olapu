package routers

import (
	"api/bson"
	"api/request"
	olapuHttp "api/response"
	"github.com/gin-gonic/gin"
	"net/http"
	"time"
)

func CreateResource(c *gin.Context) {
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
		Uid:        c.GetString("uid"),
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

func GetResource(c *gin.Context) {
	var payload request.QueryResourceParam
	err := c.BindQuery(&payload)
	if err != nil {
		c.JSON(http.StatusBadRequest, olapuHttp.ErrorBuilder(olapuHttp.BadRequestError, &olapuHttp.RequestPayloadMissing))
		return
	}
	// 直接去查
	resource, err := bson.SelectResource(bson.QueryResource{
		Name: payload.Name, ParentId: payload.ParentId,
	})
	if err != nil {
		message := err.Error()
		c.JSON(http.StatusInternalServerError, olapuHttp.ErrorBuilder(olapuHttp.InternalServerError, &message))
		return
	}
	c.JSON(http.StatusOK, resource)
}
