package bson

import (
	"api/content"
	"api/datasource"
	"go.mongodb.org/mongo-driver/mongo"
)

func GetCollection(table string) *mongo.Collection {
	client := datasource.GetMongoDBClient()
	database := client.Database(content.Context.Database)
	return database.Collection(table)
}
