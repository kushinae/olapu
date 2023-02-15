package types

// Content 程序内容
type Content struct {
	ApplicationProperties
}

// Application 项目对象
type Application interface {
	// Run 启动程序，返回启动之后的程序内容对象
	Run() Content
}
