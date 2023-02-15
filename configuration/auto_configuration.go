package configuration

import (
	"common/settings"
	"common/types"
	"github.com/spf13/viper"
	"log"
)

var viperConfig = viper.New()

// LoadingProperties 加载配置
func LoadingProperties() types.ApplicationProperties {
	preSetting()
	if err := viperConfig.ReadInConfig(); err != nil {
		log.Fatal("无法从 " + settings.ConfigFilepath() + " 加载配置文件")
	}
	return types.ApplicationProperties{
		WebProperties:        getWebProperties(),
		DataSourceProperties: getDatasourceProperties(),
	}
}

// 配置对象前置初始化
func preSetting() {
	viperConfig.SetConfigFile(settings.ConfigFilepath())
}

func getWebProperties() types.WebProperties {
	return types.WebProperties{
		Port: viperConfig.GetInt("web.port"),
	}
}

func getDatasourceProperties() types.DataSourceProperties {
	datasourcePreKey := "datasource." + viperConfig.GetString("datasource.driver")
	return types.DataSourceProperties{
		Driver: viperConfig.GetString("datasource.driver"),
		MySQLProperties: types.MySQLProperties{
			Username: viperConfig.GetString(datasourcePreKey + ".username"),
			Password: viperConfig.GetString(datasourcePreKey + ".password"),
			Host:     viperConfig.GetString(datasourcePreKey + ".host"),
			Port:     viperConfig.GetInt(datasourcePreKey + ".port"),
			Database: viperConfig.GetString(datasourcePreKey + ".database"),
		},
	}
}
