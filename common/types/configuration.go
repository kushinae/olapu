package types

type IAutoConfiguration interface {
	WebAutoConfiguration(properties ApplicationProperties)
}
