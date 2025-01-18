//A user can also book an appointment by filling a form on the website, but this is handled internally using the API.
//Your job is to write unit tests for the following scenarios:

//1) Check if the user has the permission to make a new reservation
//2) If there is no conflicts with other appointments, add a new appointment. Otherwise return "conflict".
//3) Check if there are any conflicts with another appointment, and return the conflict.
//4) Update an existing appointment. If the time of the update does not have any conflicts, it will be updated. If there is a conflict, then "conflict" will be returned and the old appointment will be kept.
//5) Remove an appointment. It should also check if there are conflicts with another apppointment, and return them as well.
package main

import (
	"fmt"
)

type Service interface {
	IsValidUser(user User) bool
	NewAppointment(a Appointment) error
	UpdateAppointment(a Appointment) error
	DeleteAppointment(a Appointment) error
}

// type ClientService struct {
// 	service Service
// }

type Appointment struct {
	ID      string `json:"id"`
	User    User   `json:"user"`
	Date    int64  `json:"date"`
	StartAt string `json:"start_at"`
	EndAt   string `json:"end_at"`
}

type User struct {
	Name     string `json:"name"`
	Surname  string `json:"surname"`
	Email    string `json:"email"`
	Username string `json:"username"`
	Phone    string `json:"phone"`
	Age      int    `json:"age"`
}

func IsValidUser(user User) bool {
	return user.Name != "" && user.Surname != "" && user.Email != "" && user.Username != "" && user.Phone != "" && user.Age != 0
}

// func NewClientService(service Service) *ClientService {
// 	return &ClientService{service: service}
// }

func (s ClientService) NewAppointment(a Appointment) error {
	if s.service.IsValidUser(a.User) {
		return nil
	} else {
		return "invalid user"
	}
}

func (s ClientService) UpdateAppointment(a Appointment) error {
	return nil
}

func (s ClientService) DeleteAppointment(a Appointment) error {
	return nil
}

type ClientService struct {
	service Service
}

func main() {
	user := User{Name: "John", Surname: "Smith", Email: "john.smith@email.com", Username: "jsmith", Phone: "123456789", Age: 20}
	a := Appointment{"id", user, 1638385600, "18:00", "19:00"}

	s := &ClientService{service: Service{}}
	s.NewAppointment(a)
}

// func (c *ClientService) NewAppointment(a Appointment) error {
// 	return c.service.NewAppointment(a)
// }

// func (c *ClientService) UpdateAppointment(a Appointment) error {
// 	return c.service.UpdateAppointment(a)
// }

// func (c *ClientService) DeleteAppointment(a Appointment) error {
// 	return c.service.DeleteAppointment(a)
// }

// type Service struct {
// 	UserRepo UserRepository
// }

// func IsValidUser(user User) bool {
// 	if user.Name != "" && user.Surname != "" && user.Email != "" && user.Username != "" && user.Phone != "" && user.Age != 0 {
// 		return true
// 	} else {
// 		return false
// 	}
// }

// func (s Service) NewAppointment(a Appointment) error {
// 	if s.IsValidUser(a.User) {
// 		return nil
// 	} else {
// 		return "invalid user"
// 	}
// }

// func (s Service) UpdateAppointment(a Appointment) error {
// 	return nil
// }

// func (s Service) DeleteAppointment(a Appointment) error {
// 	return nil
// }

// type UserRepository struct {
// 	UserRepo UserRepository
// }

// func (r *UserRepository) IsValidUser(user User) bool {
// 	if user.Name != "" && user.Surname != "" && user.Email != "" && user.Username != "" && user.Phone != "" && user.Age != 0 {
// 		return true
// 	} else {
// 		return false
// 	}
// }

// func (r *UserRepository) NewAppointment(a Appointment) error {
// 	if r.IsValidUser(a.User) {
// 		return nil
// 	} else {
// 		return "invalid user"
// 	}
// }

// func (r *UserRepository) UpdateAppointment(a Appointment) error {
// 	return nil
// }

// func (r *UserRepository) DeleteAppointment(a Appointment) error {
// 	return nil
// }

// type User struct {
// 	Name     string `json:"name"`
// 	Surname  string `json:"surname"`
// 	Email    string `json:"email"`
// 	Username string `json:"username"`
// 	Phone    string `json:"phone"`
// 	Age      int    `json:"age"`
// }

// type Appointment struct {
// 	ID      string `json:"id"`
// 	User    User   `json:"user"`
// 	Date    int64  `json:"date"`
// 	StartAt string `json:"start_at"`
// 	EndAt   string `json:"end_at"`
// }

// func main() {
// 	user := User{Name: "John", Surname: "Smith", Email: "john.smith@email.com", Username: "jsmith", Phone: "123456789", Age: 20}
// 	a := Appointment{"id", user, 1638385600, "18:00", "19:00"}
// 	s := Service{}
// 	fmt.Println(s.IsValidUser(user))
// }

// func main() {
// 	user := User{Name: "John", Surname: "Smith", Email: "john.smith@email.com", Username: "jsmith", Phone: "123456789", Age: 20}
// 	a := Appointment{"id", user, 1638385600, "18:00", "19:00"}
// 	s := Service{}
// 	r := UserRepository{}
// 	fmt.Println(s.IsValidUser(user))
// }

// func main() {
// 	user := User{Name: "John", Surname: "Smith", Email: "john.smith@email.com", Username: "jsmith", Phone: "123456789", Age: 20}
// 	a := Appointment{"id", user, 1638385600, "18:00", "19:00"}
// 	s := Service{}
// 	r := UserRepository{}
// 	fmt.Println(s.IsValidUser(user))
// }

// func main() {
// 	user := User{Name: "John", Surname: "Smith", Email: "john.smith@email.com", Username: "jsmith", Phone: "123456789", Age: 20}
// 	a := Appointment{"id", user, 1638385600, "18:00", "19:00"}
// 	s := Service{}
// 	r := UserRepository{}
// 	fmt.Println(s.IsValidUser(user))
// }
