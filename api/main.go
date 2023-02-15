package main

import (
	"bootstrap/application"
)

func main() {
	app := new(application.GlobalApplication)
	content := app.Run()
	println(content.ApplicationProperties.DataSourceProperties.Host)
}
