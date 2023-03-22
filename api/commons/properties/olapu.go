package properties

type WebProperty struct {
	Port int
}

type DataSourceProperty struct {
	Driver   string `yaml:"driver"`
	Username string `yaml:"username"`
	Password string `yaml:"password"`
	Host     string `yaml:"host"`
	Port     int    `yaml:"port"`
	Database string `yaml:"database"`
}

type OlapuProperty struct {
	WebProperty
	DataSourceProperty
}
