package util

import (
	"log"
	"strconv"
)

func String2Int(source string) int {
	result, err := strconv.Atoi(source)
	if err != nil {
		log.Fatal("数据转换失败, 从"+source+"到int类型", err.Error())
	}
	return result
}

func Int2String(source int) string {
	return strconv.Itoa(source)
}
