package se.iths.rest;

import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@PermitAll

public class TeacherRest {
    @Inject
    TeacherService teacherService;

    @Path("")
    @GET
    public Response getAllTeachers() {
        List<Teacher> foundTeachers = teacherService.getAllTeachers();
        if (foundTeachers == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("No students were found.").type(MediaType.TEXT_PLAIN_TYPE)
                    .type(MediaType.APPLICATION_JSON)
                    .build());
        }
        return Response.ok(foundTeachers).build();
    }
}
