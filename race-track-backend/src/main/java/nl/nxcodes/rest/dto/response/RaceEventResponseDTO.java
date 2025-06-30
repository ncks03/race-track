package nl.nxcodes.rest.dto.response;

import nl.nxcodes.model.domain.RaceEvent;

import java.util.List;
import java.util.UUID;

public record RaceEventResponseDTO(UUID uuid, String name, List<RaceSessionResponseDTO> sessions) {
    public static RaceEventResponseDTO fromEntity(RaceEvent event) {
        return new RaceEventResponseDTO(
                event.getUuid(),
                event.getName(),
                event.getSessions().stream()
                        .map(RaceSessionResponseDTO::fromEntity)
                        .toList()
        );
    }
}
