package application

import (
	"common/types"
	"configuration"
)

// GlobalApplication 全局默认Application 项目对象
type GlobalApplication struct {
}

// Run 启动程序
func (application GlobalApplication) Run() types.Content {
	return run()
}

// 启动项目并且获取程序内容对象
func run() types.Content {
	properties := configuration.LoadingProperties()
	// 启动
	return types.Content{
		ApplicationProperties: properties,
	}
}
