package bson

import (
	"context"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/mongo"
	"time"
)

const table = "t_account"

type Account struct {
	Id         *string   `bson:"_id,omitempty"`
	Username   string    `bson:"username"`
	Password   string    `bson:"password"`
	Nickname   string    `bson:"nickname"`
	Avatar     string    `bson:"avatar"`
	CreateTime time.Time `bson:"create_time"`
	ModifyTime time.Time `bson:"modify_time"`
	Deleted    bool      `bson:"deleted"`
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
	collection := GetCollection(table)
	one := collection.FindOne(context.TODO(), bson.M{"username": payload.Username, "password": payload.Password})
	account := Account{}
	err := one.Decode(account)
	return account, err
}

func QueryUsername(username string) (*Account, error) {
	collection := GetCollection(table)
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
	collection := GetCollection(table)
	return collection.InsertOne(context.TODO(), Account{
		Id:         nil,
		Username:   payload.Username,
		Password:   payload.Password,
		Nickname:   payload.Nickname,
		CreateTime: time.Now(),
		ModifyTime: time.Now(),
		Deleted:    false,
	})
}
