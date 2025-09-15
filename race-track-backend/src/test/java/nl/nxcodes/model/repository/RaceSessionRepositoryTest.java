package nl.nxcodes.model.repository;

import jakarta.persistence.*;
import nl.nxcodes.model.domain.RaceSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RaceSessionRepositoryTest {

    @Mock
    private EntityManager entityManagerMock;

    @InjectMocks
    private RaceSessionRepository raceSessionRepository;

    List<RaceSession> raceSessions;

    @BeforeEach
    void setUp() {
        raceSessionRepository = new RaceSessionRepository();
    }

    @Test
    void findAll_withExistingRaceSessions_getsAllRaceSessions() {
        // Arrange
        when(entityManagerMock.createQuery(eq("SELECT re FROM RaceSession re"), eq(RaceSession.class)).getResultList())
                .thenReturn(raceSessions);

        // Act
        List<RaceSession> foundSessions = raceSessionRepository.findAll();

        // Assert
        assertThat(foundSessions).isEqualTo(raceSessions);
    }

    @Test
    void findAll_noRaceSessions_returnsEmptyList() {
        // Arrange
        when(entityManagerMock.createQuery(eq("SELECT re FROM RaceSession re"), eq(RaceSession.class)).getResultList())
                .thenReturn(Collections.emptyList());

        // Act
        List<RaceSession> foundSessions = raceSessionRepository.findAll();

        // Assert
        assertThat(foundSessions.isEmpty()).isTrue();
    }
}