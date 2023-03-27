package bson

import (
	"context"
	"go.mongodb.org/mongo-driver/mongo"
	"time"
)

const resourceTableName = "t_resource"

type Resource struct {
	Id string `bson:"_id,omitempty" json:"id"`
	// directory 目录 file 文件
	Type string `bson:"type" json:"type"`
	// 文件名称
	Name     string `bson:"name" json:"name"`
	ParentId string `bson:"parent_id" json:"parent_id"`
	// 文件内容 如果是文件夹则没有内容
	Content string `bson:"content" bson:"content"`
	// 所属人
	Uid        string    `bson:"uid" json:"uid"`
	CreateTime time.Time `bson:"create_time" json:"create_time"`
	ModifyTime time.Time `bson:"modify_time" json:"modify_time"`
	Deleted    bool      `bson:"deleted" json:"deleted"`
}

func InsertResource(payload Resource) (*mongo.InsertOneResult, error) {
	collection := GetCollection(resourceTableName)
	return collection.InsertOne(context.TODO(), payload)
}
