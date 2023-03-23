package application

import (
	"api/commons/properties"
	olapuContent "api/content"
	"api/datasource"
	"api/routers"
	"api/util"
	"context"
	"fmt"
	"github.com/gin-gonic/gin"
	_ "github.com/go-sql-driver/mysql"
	"github.com/spf13/viper"
	_ "go.mongodb.org/mongo-driver/mongo"
	"log"
	"os"
	"path/filepath"
)

var viperConfig = viper.New()
var GinEngine *gin.Engine

type IAutoConfiguration interface {
	WebAutoConfiguration(property properties.OlapuProperty)
	DataSourceAutoConfiguration(property properties.OlapuProperty)
}

type GlobalAutoConfiguration struct {
}

func (global GlobalAutoConfiguration) WebAutoConfiguration(property properties.OlapuProperty) {
	GinEngine = gin.Default()
	routers.RegisterRouters(GinEngine)
	err := GinEngine.Run(fmt.Sprintf("0.0.0.0:%s", util.Int2String(property.WebProperty.Port)))
	if err != nil {
		log.Fatalln(fmt.Sprintf("启动服务失败，可能是因为端口 %s 已经被占用", util.Int2String(property.WebProperty.Port)))
	}
}

func (global GlobalAutoConfiguration) DataSourceAutoConfiguration(property properties.OlapuProperty) {
	testConnection(property)
}

// Run 启动程序
func Run() olapuContent.Content {
	// 加载配置
	loadingProperties := LoadingProperties()

	globalAutoConfiguration := new(GlobalAutoConfiguration)
	olapuContent.Context = olapuContent.Content{
		OlapuProperty: loadingProperties,
	}
	// 前置自动化配置
	globalAutoConfiguration.DataSourceAutoConfiguration(loadingProperties)
	globalAutoConfiguration.WebAutoConfiguration(loadingProperties)
	return olapuContent.Context
}

func LoadingProperties() properties.OlapuProperty {
	preSetting()
	if err := viperConfig.ReadInConfig(); err != nil {
		log.Fatal("无法从 " + ConfigFilepath() + " 加载配置文件")
	}
	return properties.OlapuProperty{
		WebProperty:        getWebProperty(),
		DataSourceProperty: getDataSourceProperty(),
	}
}

func getDataSourceProperty() properties.DataSourceProperty {
	preKey := "datasource"
	driverType := viperConfig.GetString(preKey + ".driver")
	return properties.DataSourceProperty{
		Driver:   driverType,
		Username: viperConfig.GetString(preKey + ".username"),
		Password: viperConfig.GetString(preKey + ".password"),
		Host:     viperConfig.GetString(preKey + ".host"),
		Port:     viperConfig.GetInt(preKey + ".port"),
		Database: viperConfig.GetString(preKey + ".database"),
	}
}

func getWebProperty() properties.WebProperty {
	return properties.WebProperty{
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

func testConnection(property properties.OlapuProperty) {
	// 驱动 HOST 端口
	url := fmt.Sprintf("%s://%s:%s",
		property.Driver,
		property.Host,
		util.Int2String(property.DataSourceProperty.Port))

	err := datasource.ConfigureMongoDBClient(url, property).Ping(context.TODO(), nil)

	if err != nil {
		log.Fatal("与数据库服务器通信失败,请检查链接信息或确定服务是否已经启动", err.Error())
	}
}
