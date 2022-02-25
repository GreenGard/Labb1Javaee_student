package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@PermitAll
public class StudentRest {
    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createStudent(Student student, @Context UriInfo uriInfo) {
        studentService.createStudent(student);
        if (student == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("No students were found.").type(MediaType.TEXT_PLAIN_TYPE)
                    .type(MediaType.APPLICATION_JSON)
                    .build());
        }
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(String.valueOf(student.getId()));
        return Response.created(uriBuilder.build()).build();
    }

    @Path("")
    @GET
    public Response getAllStudents() {
        List<Student> foundStudents = studentService.getAllStudents();
        if (foundStudents == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("No students were found.").type(MediaType.TEXT_PLAIN_TYPE)
                    .type(MediaType.APPLICATION_JSON)
                    .build());
        }
        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @PUT
    public Response updateStudent(Student student) {

        studentService.updateStudent(student);


        if (student == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("No students were found.").type(MediaType.TEXT_PLAIN_TYPE)
                    .type(MediaType.APPLICATION_JSON)
                    .build());
        }
        return Response.ok(student).build();
    }


    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Item does not exist or have been deleted.")
                    .type(MediaType.APPLICATION_JSON)
                    .build());
        }
        studentService.deleteStudent(id);
        return Response.ok().build();
    }

    @Path("{id}")
    @GET
    public Response getStudentByLastname(@QueryParam("lastName") String lastName) {
        if (lastName == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Item does not exist or have been deleted.")
                    .type(MediaType.APPLICATION_JSON)
                    .build());
        }
        return Response.ok(studentService.getStudentByLastname(lastName)).build();
    }
}
