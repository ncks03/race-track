package nl.nxcodes.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.nxcodes.model.domain.RaceEvent;
import nl.nxcodes.model.repository.RaceEventRepository;
import nl.nxcodes.rest.dto.post.RaceEventPostDTO;
import nl.nxcodes.rest.dto.response.RaceEventResponseDTO;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Path("/events")
public class RaceEventResource {

    private static final String EVENTS_ENDPOINT = "/api/events";

    private final RaceEventRepository raceEventRepository;

    @Inject
    public RaceEventResource(RaceEventRepository raceEventRepository) {
        this.raceEventRepository = raceEventRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRaceEvents() {

        List<RaceEventResponseDTO> raceEvents = raceEventRepository.findAll().stream()
                .map(RaceEventResponseDTO::fromEntity)
                .toList();

        // Throw exception on not found for mapper to pick up
        if (raceEvents.isEmpty()) {
            throw new WebApplicationException("No race events found", Response.Status.NOT_FOUND);
        }

        return Response.ok(raceEvents).build();
    }

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRaceEvent(@PathParam("uuid") UUID uuid) {

        RaceEventResponseDTO event = raceEventRepository.findByUuid(uuid)
                .map(RaceEventResponseDTO::fromEntity)
                .orElseThrow(() -> new WebApplicationException("No race event found for id", Response.Status.NOT_FOUND));

        return Response.ok(event).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRaceEvent(RaceEventPostDTO raceEventDto) {

        RaceEvent saved = raceEventRepository.save(new RaceEvent(raceEventDto));

        return Response.created(URI.create(EVENTS_ENDPOINT + saved.getUuid())).build();
    }
}
