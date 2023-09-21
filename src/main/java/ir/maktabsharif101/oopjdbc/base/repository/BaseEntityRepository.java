package ir.maktabsharif101.oopjdbc.base.repository;

import ir.maktabsharif101.oopjdbc.base.domain.Entity;

@SuppressWarnings("unused")
public interface BaseEntityRepository {

    Entity[] findAll();

    Entity findById(Long id);

    void deleteById(Long id);

    long count();

    Entity save(Entity entity);

    Entity update(Entity entity);

    boolean existsById(Long id);

}
