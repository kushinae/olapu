package util

import (
	"fmt"
	"strings"
)

func StringIsEmpty(str string) bool {
	return str == ""
}

func Format(template string, values ...string) string {
	return fmt.Sprintf(template, values)
}

func Split(str string, sep string) []string {
	return strings.Split(str, sep)
}
