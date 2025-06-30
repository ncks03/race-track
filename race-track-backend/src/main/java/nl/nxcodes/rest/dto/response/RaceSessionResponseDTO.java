package nl.nxcodes.rest.dto.response;

import nl.nxcodes.model.domain.RaceSession;
import nl.nxcodes.model.domain.SessionType;

import java.time.LocalDateTime;
import java.util.UUID;

public record RaceSessionResponseDTO(UUID uuid, SessionType sessionType, LocalDateTime startTime) {
    public static RaceSessionResponseDTO fromEntity(RaceSession session) {
        return new RaceSessionResponseDTO(
                session.getUuid(),
                session.getSessionType(),
                session.getStartTime()
        );
    }
}
