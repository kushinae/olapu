package bson

import (
	"api/util"
	"context"
	"go.mongodb.org/mongo-driver/bson"
	"go.mongodb.org/mongo-driver/bson/primitive"
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
	Content string `bson:"content" bson:"content" json:"content"`
	// 所属人
	Uid        string    `bson:"uid" json:"uid"`
	CreateTime time.Time `bson:"create_time" json:"create_time"`
	ModifyTime time.Time `bson:"modify_time" json:"modify_time"`
	Deleted    bool      `bson:"deleted" json:"deleted"`
}

type QueryResource struct {
	Name     string `bson:"name" json:"name"`
	ParentId string `bson:"parent_id" json:"parent_id"`
}

func InsertResource(payload Resource) (*mongo.InsertOneResult, error) {
	collection := GetCollection(resourceTableName)
	return collection.InsertOne(context.TODO(), payload)
}

func SelectResource(payload QueryResource) ([]Resource, error) {
	collection := GetCollection(resourceTableName)
	filter := bson.D{}

	if util.StringNotEmpty(payload.Name) {
		filter = append(filter, bson.E{
			Key: "name",
			Value: bson.M{
				"$regex": primitive.Regex{Pattern: util.Format(".*%s.*", payload.Name)},
			},
		})
	}

	filter = append(filter, bson.E{
		Key: "parent_id", Value: payload.ParentId,
	})

	resources := make([]Resource, 0)

	cur, err := collection.Find(context.TODO(), filter)
	if cur == nil {
		return resources, nil
	}
	if err = cur.Err(); err != nil {
		return nil, err
	}

	for cur.Next(context.TODO()) {
		// create a value into which the single document can be decoded
		var elem Resource
		err := cur.Decode(&elem)
		if err != nil {
			return nil, err
		}

		resources = append(resources, elem)
	}
	return resources, nil

}
