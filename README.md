## Student Management System

Its A SpringBoot REST API application For Student management System that will manage sstudent admission courses and enrollments


## Admin

Admin Login
Add Student
Add Address
Add Course
Assign Course to Student
search Student by name
Get Students by Course

## Student
Student login
Update profile
view Courses
Leave Course


## Tech

Java 21
SpringBoot
Spring Security
Spring Data Jpa
Hibernate
MySQL
Maven
Swagger
Postman


## Database
Create database

CREATE DATABASE student_management_system

Update database configuration inside application.yml

username: YOUR_USERNAME
password: YOUR_PASSWORD


## Run Project

Clone Repository

git clone https://github.com/sanjeevraj9/student-management-system.git

Run Spring Boot application --

-----------------------------------------------------------------------------------

## Api Documentation

http://localhost:8082/swagger-ui/index.html



## PostMan Collection

Postman Collection available inside

postman/


## Authentication

Basic Auth is used

Admin login

username:admin
password:admin123


## Rest APIS

### Admin

Post - /api/admin/login
Post - /api/admin/student
Post- /api/admin/student/{id}/address
Post - /api/admin/course
Post - /api/admin/assign-course
Post - /api/admin/students
Post - /api/admin/course/{courseId}/students


### Students

Post - /api/students/login
Put - /api/students/{studentId}
Get - /api/students/{studentId}/courses
Delete - /api/students/{studnetId}/course/{courseId}




## Developed By 
Sanjeev Raj
