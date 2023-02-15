package types

type ApplicationProperties struct {
	WebProperties
	DataSourceProperties
}

type DataSourceProperties struct {
	Driver string
	MySQLProperties
}

type MySQLProperties struct {
	Username string
	Password string
	Host     string
	Port     int
	Database string
}

type WebProperties struct {
	Port int
}
