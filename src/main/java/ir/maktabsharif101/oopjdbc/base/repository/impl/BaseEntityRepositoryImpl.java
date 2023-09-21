package ir.maktabsharif101.oopjdbc.base.repository.impl;

import ir.maktabsharif101.oopjdbc.base.domain.Entity;
import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;

public abstract class BaseEntityRepositoryImpl
        implements BaseEntityRepository {

    @Override
    public Entity[] findAll() {
        return new Entity[0];
    }

    @Override
    public Entity findById(Long id) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public Entity save(Entity entity) {
        return null;
    }

    @Override
    public Entity update(Entity entity) {
        return null;
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("deleted by id : " + id);
    }


}
