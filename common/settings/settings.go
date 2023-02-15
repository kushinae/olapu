package settings

import (
	"log"
	"os"
	"path/filepath"
)

const (
	configPath     = "conf"
	ConfigFilename = "application"
	ConfigFiletype = "yaml"
	ConfigFile     = ConfigFilename + "." + ConfigFiletype
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
	return ConfigPath() + string(os.PathSeparator) + ConfigFile
}
