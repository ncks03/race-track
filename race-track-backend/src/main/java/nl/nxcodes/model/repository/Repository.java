package nl.nxcodes.model.repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
public abstract class Repository<T> {

    @Inject
    EntityManager em;

    public abstract Optional<T> findById(Long id);

    public abstract Optional<T> findByUuid(UUID uuid);

    public abstract List<T> findAll();

    public abstract T save(T entity);

    public abstract void delete(T entity);
}