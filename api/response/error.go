package response

var (
	badRequestError = Error{
		Code:    400,
		Message: "BadRequest",
	}
)

type (
	Error struct {
		Code    int    `json:"code"`
		Message string `json:"message"`
	}
)

func BadRequest() Error {
	return Error{
		Code:    badRequestError.Code,
		Message: badRequestError.Message,
	}
}
