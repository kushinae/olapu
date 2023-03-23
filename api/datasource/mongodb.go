package datasource

import (
	"api/commons/properties"
	"api/util"
	"context"
	"fmt"
	"go.mongodb.org/mongo-driver/mongo"
	"go.mongodb.org/mongo-driver/mongo/options"
	"log"
)

var client *mongo.Client

func getEngine(jdbc string, property properties.OlapuProperty) *mongo.Client {
	connection, err := mongo.Connect(context.TODO(), options.Client().ApplyURI(jdbc).SetAuth(options.Credential{Username: property.Username, Password: property.Password}))
	if err != nil {
		log.Fatalln(fmt.Sprintf("启动服务失败，可能是因为端口 %s 已经被占用", util.Int2String(property.WebProperty.Port)))
	}
	return connection
}

func ConfigureMongoDBClient(jdbc string, property properties.OlapuProperty) *mongo.Client {
	if client != nil {
		return client
	} else {
		client = getEngine(jdbc, property)
	}
	return client
}

func GetMongoDBClient() *mongo.Client {
	if client != nil {
		return client
	} else {
		log.Fatalln("No related client object found")
	}
	return nil
}
