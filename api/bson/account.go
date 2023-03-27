package bson

import (
	"context"
	"github.com/google/uuid"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
	"time"
)

const accountTableName = "t_account"

type Account struct {
	Id         string    `bson:"_id,omitempty" json:"id"`
	Username   string    `bson:"username" json:"username"`
	Password   string    `bson:"password" json:"password"`
	Nickname   string    `bson:"nickname" json:"nickname"`
	Avatar     string    `bson:"avatar" json:"avatar"`
	Uid        string    `bson:"uid" json:"uid"`
	CreateTime time.Time `bson:"create_time" json:"create_time"`
	ModifyTime time.Time `bson:"modify_time" json:"modify_time"`
	Deleted    bool      `bson:"deleted" json:"deleted"`
}

type LoginBson struct {
	Username string `bson:"username"`
	Password string `bson:"password"`
}

type RegisterBson struct {
	Username string `bson:"username"`
	Password string `bson:"password"`
	Nickname string `bson:"nickname"`
}

func GetLogin(payload LoginBson) (Account, error) {
	collection := GetCollection(accountTableName)
	one := collection.FindOne(context.TODO(), bson.M{"username": payload.Username, "password": payload.Password})
	account := Account{}
	err := one.Decode(&account)
	return account, err
}

func QueryUsername(username string) (*Account, error) {
	collection := GetCollection(accountTableName)
	one := collection.FindOne(context.TODO(), bson.D{
		{
			"username",
			username,
		},
	})
	err := one.Err()
	account := Account{}
	if err != nil {
		return nil, nil
	}
	err = one.Decode(&account)
	if err != nil {
		return nil, err
	}
	return &account, err

}

func Register(payload RegisterBson) (*mongo.InsertOneResult, error) {
	collection := GetCollection(accountTableName)
	now := time.Now()
	createUuid, err := uuid.NewUUID()
	if err != nil {
		return nil, err
	}
	return collection.InsertOne(context.TODO(), Account{
		Username:   payload.Username,
		Password:   payload.Password,
		Nickname:   payload.Nickname,
		Uid:        createUuid.String(),
		CreateTime: now,
		ModifyTime: now,
		Deleted:    false,
	})
}
