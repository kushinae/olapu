package application

import (
	"api/controller"
	"bootstrap/util"
	"database/sql"
	"fmt"
	"github.com/gin-gonic/gin"
	_ "github.com/go-sql-driver/mysql"
	"github.com/spf13/viper"
	"log"
	"os"
	"path/filepath"
)

var viperConfig = viper.New()
var Connection *sql.DB
var engine *gin.Engine

type IAutoConfiguration interface {
	WebAutoConfiguration(property OlapuProperty)
	DataSourceAutoConfiguration(property OlapuProperty)
}

type Content struct {
	OlapuProperty
}

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

type GlobalAutoConfiguration struct {
}

func (global GlobalAutoConfiguration) WebAutoConfiguration(property OlapuProperty) {
	engine = gin.Default()
	registerRouter()
	err := engine.Run(fmt.Sprintf("0.0.0.0:%s", util.Int2String(property.WebProperty.Port)))
	if err != nil {
		log.Fatalln(fmt.Sprintf("启动服务失败，可能是因为端口 %s 已经被占用", util.Int2String(property.WebProperty.Port)))
	}
}

func (global GlobalAutoConfiguration) DataSourceAutoConfiguration(property OlapuProperty) {
	var err error
	url := fmt.Sprintf("%s:%s@(%s:%s)/%s",
		property.Username,
		property.Password,
		property.Host,
		util.Int2String(property.DataSourceProperty.Port),
		property.Database)
	Connection, err = sql.Open(property.Driver, url)

	if err != nil {
		log.Fatal("创建数据库连接失败,请检查", url, err.Error(), err)

	}
	if err != nil {
		log.Fatal("创建数据库连接失败", err.Error())
	}
	testConnection()
}

// Run 启动程序
func Run() Content {
	// 加载配置
	properties := LoadingProperties()

	globalAutoConfiguration := new(GlobalAutoConfiguration)
	// 前置自动化配置
	globalAutoConfiguration.DataSourceAutoConfiguration(properties)
	globalAutoConfiguration.WebAutoConfiguration(properties)
	// 启动
	return Content{
		OlapuProperty: properties,
	}
}

func LoadingProperties() OlapuProperty {
	preSetting()
	if err := viperConfig.ReadInConfig(); err != nil {
		log.Fatal("无法从 " + ConfigFilepath() + " 加载配置文件")
	}
	return OlapuProperty{
		WebProperty:        getWebProperty(),
		DataSourceProperty: getDataSourceProperty(),
	}
}

func getDataSourceProperty() DataSourceProperty {
	preKey := "datasource"
	driverType := viperConfig.GetString(preKey + ".driver")
	return DataSourceProperty{
		Driver:   driverType,
		Username: viperConfig.GetString(preKey + ".username"),
		Password: viperConfig.GetString(preKey + ".password"),
		Host:     viperConfig.GetString(preKey + ".host"),
		Port:     viperConfig.GetInt(preKey + ".port"),
		Database: viperConfig.GetString(preKey + ".database"),
	}
}

func getWebProperty() WebProperty {
	return WebProperty{
		Port: viperConfig.GetInt("web.port"),
	}
}

func preSetting() {
	viperConfig.SetConfigFile(ConfigFilepath())
}

const (
	configPath     = "conf"
	configFilename = "application"
	configFiletype = "yaml"
	configFile     = configFilename + "." + configFiletype
)

func ConfigPath() string {
	dir, err := os.Getwd()
	rootPath := filepath.Dir(dir)
	if err != nil {
		log.Fatal("获取系统路径失败", err.Error())
	}
	return rootPath + string(os.PathSeparator) + configPath
}

func ConfigFilepath() string {
	return ConfigPath() + string(os.PathSeparator) + configFile
}

func testConnection() {
	err := Connection.Ping()
	if err != nil {
		log.Fatal("与数据库服务器通信失败,请检查链接信息或确定服务是否已经启动", err.Error())
	}
}

func registerRouter() {
	engine.GET("/ping", controller.Ping)
}
