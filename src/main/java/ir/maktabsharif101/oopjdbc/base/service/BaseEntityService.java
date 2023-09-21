package ir.maktabsharif101.oopjdbc.base.service;

import ir.maktabsharif101.oopjdbc.base.domain.Entity;

public interface BaseEntityService {

    Entity[] findAll();

    Entity findById(Long id);

    void deleteById(Long id);

    long count();

    Entity save(Entity entity);

    Entity update(Entity entity);

    boolean existsById(Long id);
}
