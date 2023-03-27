package request

type CreateDirectoryParam struct {
	Name     string `json:"name"`
	Type     string `json:"type"`
	ParentId string `json:"parent_id"`
	Content  string `bson:"content" bson:"content"`
}
