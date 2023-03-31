package request

type CreateDirectoryParam struct {
	Name     string `json:"name"`
	Type     string `json:"type"`
	ParentId string `json:"parent_id"`
	Content  string `bson:"content" bson:"content"`
}

type QueryResourceParam struct {
	Name     string `json:"name" form:"name"`
	ParentId string `json:"parent_id" form:"parent_id"`
}
