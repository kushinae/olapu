package http

var (
	Ok    = Status{Code: 0, Message: "Success", Data: nil}
	Error = Status{Code: -1, Message: "Error", Error: "Unknown Request Error"}

	AccountError = Status{Code: 100000, Message: "Account Error"}

	BadRequest = Status{Code: 400000, Message: "Bad Request"}
)

type Status struct {
	Code    int    `json:"code"`
	Message string `json:"message"`
	Error   string `json:"error"`
	Data    any    `json:"data"`
}

func (status *Status) WithCode(code int) Status {
	status.Code = code
	return *status
}

func (status *Status) WithMessage(message string) Status {
	status.Message = message
	return *status
}

func (status *Status) WithData(data any) Status {
	status.Data = data
	return *status
}

func (status *Status) WithError(error string) Status {
	status.Error = error
	return *status
}
