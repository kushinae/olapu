package application

import (
	"common/types"
	"configuration"
)

type AutoConfiguration struct {
}

// GlobalApplication 全局默认Application 项目对象
type GlobalApplication struct {
}

func (application AutoConfiguration) WebAutoConfiguration(properties types.ApplicationProperties) {

}

// Run 启动程序
func (application GlobalApplication) Run() types.Content {
	content := run()
	return content
}

// 启动项目并且获取程序内容对象
func run() types.Content {
	properties := configuration.LoadingProperties()
	// 启动
	app := new(AutoConfiguration)
	app.WebAutoConfiguration(properties)
	return types.Content{
		ApplicationProperties: properties,
	}
}
