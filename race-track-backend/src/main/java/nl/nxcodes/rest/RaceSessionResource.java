package nl.nxcodes.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.nxcodes.model.domain.RaceSession;
import nl.nxcodes.model.repository.RaceSessionRepository;
import nl.nxcodes.rest.dto.response.RaceSessionResponseDTO;

import java.util.UUID;

@Path("/sessions")
public class RaceSessionResource {

    private RaceSessionRepository raceSessionRepository;

    @Inject
    public RaceSessionResource(RaceSessionRepository raceSessionRepository) {
        this.raceSessionRepository = raceSessionRepository;
    }

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRaceSession(@PathParam("uuid") UUID uuid) {

        RaceSession foundSession = raceSessionRepository.findByUuid(uuid)
                .orElseThrow(() -> new WebApplicationException("No race session found", Response.Status.NOT_FOUND));

        RaceSessionResponseDTO raceSessionResponse = RaceSessionResponseDTO.fromEntity(foundSession);

        return Response.ok(raceSessionResponse).build();
    }
}
