package nl.nxcodes.model.repository;

import jakarta.enterprise.context.RequestScoped;
import nl.nxcodes.model.domain.RaceEvent;

import java.util.List;
import java.util.Optional;

@RequestScoped
public class RaceEventRepository extends Repository<RaceEvent> {

    @Override
    public Optional<RaceEvent> findById(Long id) {
        return Optional.ofNullable(
                em.find(RaceEvent.class, id)
        );
    }

    @Override
    public Optional<RaceEvent> findByUuid(String uuid) {
        return Optional.ofNullable(
                em.createQuery("select re from RaceEvent re where re.uuid = :uuid", RaceEvent.class)
                        .setParameter("uuid", uuid)
                        .getSingleResult()
        );
    }

    @Override
    public List<RaceEvent> findAll() {
        return em.createQuery("select re from RaceEvent re", RaceEvent.class).getResultList();
    }

    @Override
    public RaceEvent save(RaceEvent entity) {
        return em.merge(entity);
    }

    @Override
    public void delete(RaceEvent entity) {
        em.remove(entity);
    }
}