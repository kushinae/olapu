package util

import (
	"github.com/golang-jwt/jwt/v5"
	"time"
)

type OlapuClaims struct {
	jwt.RegisteredClaims
	Uid string
}

const SingKey = "olapu-console-token"

func GenerateToken(uid string) string {
	token := jwt.NewWithClaims(jwt.SigningMethodHS256, OlapuClaims{
		jwt.RegisteredClaims{
			Issuer:    uid,
			Audience:  jwt.ClaimStrings{"olapuapiservice-v1"},
			IssuedAt:  &jwt.NumericDate{Time: time.Now()},
			ExpiresAt: &jwt.NumericDate{Time: time.Now().AddDate(0, 15, 0)},
		},
		uid,
	})
	token.Header = map[string]interface{}{
		"typ": "JWT",
		"alg": "HS256",
	}

	// Sign and get the complete encoded token as a string using the secret verysecret
	tokenString, _ := token.SignedString([]byte(SingKey))
	return tokenString
}

func VerifyToken(token string) (*jwt.Token, error) {
	claims, err := jwt.ParseWithClaims(token, &OlapuClaims{}, func(token *jwt.Token) (interface{}, error) {
		return []byte(SingKey), nil
	})
	if err != nil {
		return nil, err
	}
	return claims, err
}
