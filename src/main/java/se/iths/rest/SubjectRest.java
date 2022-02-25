package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {
    @Inject
    SubjectService subjectService;

    @Path("{id}")
    @GET
    public Response getSubject(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);
        return Response.ok(foundSubject).build();
    }
    @Path("")
    @GET
    public Response getAllSubject() {
        List<Subject> foundSubjects = subjectService.getAllSubjects();
        if (foundSubjects == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("No students were found.").type(MediaType.TEXT_PLAIN_TYPE)
                    .type(MediaType.APPLICATION_JSON)
                    .build());
        }
        return Response.ok(foundSubjects).build();
    }
}
