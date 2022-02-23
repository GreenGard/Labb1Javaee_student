Create new student with JSON Body
@POST
Endpoint:http://localhost:8080/student-management-system/api/v1/students/
parameters:Student object as JSON Body
{
	"firstName": "test2",
	"lastName": "testsson2",
	"email":"test.test2@telia.se"
}


Get all student
@GET
Endpoint:http://localhost:8080/student-management-system/api/v1/students/
parameters:none

Update student
@PUT
Endpoint:http://localhost:8080/student-management-system/api/v1/students/{id}
parameters:Student object as JSON Body
{
	"firstName": "test2",
	"lastName": "testsson2",
	"email":"test.test2@telia.se"
	"id": 1
}

Delete student
@DELETE
Endpoint:http://localhost:8080/student-management-system/api/v1/students/{id}
parameters:Long id
{
	"firstName": "test2",
	"lastName": "testsson2",
	"email":"test.test2@telia.se"
	"id": 1
}


Get student by Lastname
@GET
Endpoint:http://localhost:8080/student-management-system/api/v1/students/
parameters:String lastName
Queryparam
name=lastName 
value="example"

