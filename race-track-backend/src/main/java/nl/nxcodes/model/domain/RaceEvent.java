package nl.nxcodes.model.domain;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import nl.nxcodes.rest.dto.post.RaceEventPostDTO;

@Entity
@NamedQuery(
        name = "RaceEvent.findByUuid",
        query = "select re from RaceEvent re where re.uuid = :uuid"
)
public class RaceEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private final UUID uuid;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<RaceSession> sessions;

    public RaceEvent() {
        this.uuid = UUID.randomUUID();
    }

    public RaceEvent(RaceEventPostDTO raceEventDto) {
        this();
        this.name = raceEventDto.name();
    }

    public Long getId() {
        return id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RaceSession> getSessions() {
        return sessions;
    }

    public void addSession(RaceSession session) {
        this.sessions.add(session);
    }

    public void setSessions(List<RaceSession> sessions) {
        this.sessions = sessions;
    }
}
