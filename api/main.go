package main

import "bootstrap/application"

func main() {
	defer application.Run()
	application.Run()
}
