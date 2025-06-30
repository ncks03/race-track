package nl.nxcodes.model.repository;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public abstract class Repository<T> {

    @Inject
    EntityManager em;

    public abstract Optional<T> findById(Long id);

    public abstract Optional<T> findByUuid(String uuid);

    public abstract List<T> findAll();

    public abstract T save(T entity);

    public abstract void delete(T entity);
}