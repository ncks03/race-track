package nl.nxcodes.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.nxcodes.model.domain.RaceEvent;
import nl.nxcodes.model.repository.RaceEventRepository;
import nl.nxcodes.rest.dto.post.RaceEventPostDTO;

import java.net.URI;
import java.util.List;

@Path("/events")
public class RaceEventResource {

    private final RaceEventRepository raceEventRepository;

    @Inject
    public RaceEventResource(RaceEventRepository raceEventRepository) {
        this.raceEventRepository = raceEventRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRaceEvents() {
        List<RaceEvent> raceEvents = raceEventRepository.findAll();

        // Throw exception on not found for mapper to pick up
        if (raceEvents.isEmpty()) {
            throw new WebApplicationException("No race events found", Response.Status.NOT_FOUND);
        }

        return Response.ok(raceEvents).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRaceEvent(RaceEventPostDTO raceEventDto) {
        RaceEvent saved = raceEventRepository.save(new RaceEvent(raceEventDto));

        return Response.created(URI.create("/api/events/" + saved.getUuid())).build();
    }
}
