package util

import (
	"github.com/golang-jwt/jwt/v5"
	"time"
)

func GenerateToken(uid string) string {
	token := jwt.NewWithClaims(jwt.SigningMethodHS256, jwt.MapClaims{
		"foo": "bar",
		"nbf": time.Date(2015, 10, 10, 12, 0, 0, 0, time.UTC).Unix(),
	})
	token.Header = map[string]interface{}{
		"typ": "JWT",
		"alg": "HS256",
	}

	// Sign and get the complete encoded token as a string using the secret verysecret
	tokenString, _ := token.SignedString([]byte(uid))
	return tokenString

}
