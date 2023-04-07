package routers

import (
	"api/bson"
	"api/request"
	olapuHttp "api/response"
	"api/util"
	"github.com/gin-gonic/gin"
	"go.mongodb.org/mongo-driver/bson/primitive"
	"net/http"
)

func Login(c *gin.Context) {
	loginParam := request.LoginParam{}
	err := c.BindJSON(&loginParam)
	if err != nil {
		c.JSON(http.StatusBadRequest, olapuHttp.ErrorBuilder(olapuHttp.BadRequestError, &olapuHttp.RequestPayloadMissing))
		return
	}

	if util.StringIsEmpty(loginParam.Username) || util.StringIsEmpty(loginParam.Password) {
		c.JSON(http.StatusBadRequest, olapuHttp.ErrorBuilder(olapuHttp.BadRequestError, &olapuHttp.UsernameOrPasswordCantBeEmpty))
		return
	}

	account, err := bson.GetLogin(bson.LoginBson{Username: loginParam.Username, Password: loginParam.Password})
	if err != nil {
		c.JSON(http.StatusBadRequest, olapuHttp.ErrorBuilder(olapuHttp.BadRequestError, &olapuHttp.UsernameOrPasswordError))
		return
	}

	result := olapuHttp.Login{
		Id:          account.Id,
		Nickname:    account.Nickname,
		Avatar:      account.Avatar,
		AccessToken: util.GenerateToken(account.Uid),
		TokenType:   "Bearer",
	}

	c.JSON(http.StatusOK, result)
}

func Logout(c *gin.Context) {
	c.JSON(http.StatusOK, nil)
}

func Register(c *gin.Context) {
	registerParam := request.ResisterParam{}
	err := c.BindJSON(&registerParam)
	if err != nil {
		c.JSON(http.StatusBadRequest, olapuHttp.ErrorBuilder(olapuHttp.BadRequestError, &olapuHttp.RequestPayloadMissing))
		return
	}
	if util.StringIsEmpty(registerParam.Nickname) {
		message := util.Format(olapuHttp.CannotBeEmpty, "nickname")
		c.JSON(http.StatusBadRequest, olapuHttp.ErrorBuilder(olapuHttp.BadRequestError, &message))
		return
	}

	if util.StringIsEmpty(registerParam.Username) {
		message := util.Format(olapuHttp.CannotBeEmpty, "username")
		c.JSON(http.StatusBadRequest, olapuHttp.ErrorBuilder(olapuHttp.BadRequestError, &message))
		return
	}

	if util.StringIsEmpty(registerParam.Password) {
		message := util.Format(olapuHttp.CannotBeEmpty, "password")
		c.JSON(http.StatusBadRequest, olapuHttp.ErrorBuilder(olapuHttp.BadRequestError, &message))
		return
	}

	account, err := bson.QueryUsername(registerParam.Username)

	if err != nil {
		message := err.Error()
		c.JSON(http.StatusInternalServerError, olapuHttp.ErrorBuilder(olapuHttp.InternalServerError, &message))
		return
	}

	if account != nil {
		message := util.Format(olapuHttp.DataExist, "username")
		c.JSON(http.StatusBadRequest, olapuHttp.ErrorBuilder(olapuHttp.BadRequestError, &message))
		return
	}

	register, err := bson.Register(bson.RegisterBson{
		Nickname: registerParam.Nickname,
		Password: registerParam.Password,
		Username: registerParam.Username,
	})
	if err != nil {
		message := err.Error()
		c.Status(http.StatusInternalServerError)
		c.JSON(http.StatusInternalServerError, olapuHttp.ErrorBuilder(olapuHttp.InternalServerError, &message))
		return
	}

	c.JSON(http.StatusOK, olapuHttp.Register{Id: register.InsertedID.(primitive.ObjectID).Hex()})
}
