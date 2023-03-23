package response

var (
	UsernameOrPasswordCantBeEmpty = "Username or password cannot be empty"
	UsernameOrPasswordError       = "Wrong username or password"
	RequestPayloadMissing         = "Missing required request payload"
	CannotBeEmpty                 = "%s cannot be empty"
	DataExist                     = "%s already exists"
)

var (
	BadRequestError = Error{
		Code:    400,
		Message: "",
		Status:  "Bad Request",
	}
	InternalServerError = Error{
		Code:    500,
		Message: "",
		Status:  "Internal Server Error",
	}
)

type (
	Error struct {
		Code    int    `json:"code"`
		Message string `json:"message"`
		Status  string `json:"status"`
	}
)

func ErrorBuilder(error Error, message *string) Error {
	return Error{
		Code:    error.Code,
		Message: *message,
		Status:  error.Status,
	}
}
