package util

import (
	"fmt"
)

func StringIsEmpty(str string) bool {
	return str == ""
}

func Format(template string, values ...string) string {
	return fmt.Sprintf(template, values)
}
