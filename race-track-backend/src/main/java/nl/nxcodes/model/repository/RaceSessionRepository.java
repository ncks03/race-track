package nl.nxcodes.model.repository;

import nl.nxcodes.model.domain.RaceSession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class RaceSessionRepository extends Repository<RaceSession> {
    @Override
    public Optional<RaceSession> findById(Long id) {
        return Optional.ofNullable(em.find(RaceSession.class, id));
    }

    @Override
    public Optional<RaceSession> findByUuid(UUID uuid) {
        return Optional.ofNullable(
                em.createNamedQuery("RaceSession.findByUuid", RaceSession.class)
                        .setParameter("uuid", uuid)
                        .getSingleResult()
        );
    }

    @Override
    public List<RaceSession> findAll() {
        return em.createQuery("SELECT re FROM RaceSession re", RaceSession.class).getResultList();
    }

    @Override
    public RaceSession save(RaceSession entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(RaceSession entity) {
        em.remove(entity);
    }
}