package ir.maktabsharif101.oopjdbc.base.service.impl;

import ir.maktabsharif101.oopjdbc.base.domain.Entity;
import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;
import ir.maktabsharif101.oopjdbc.base.service.BaseEntityService;

public class BaseEntityServiceImpl implements BaseEntityService {

    protected final BaseEntityRepository baseRepository;

    public BaseEntityServiceImpl(BaseEntityRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public Entity[] findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Entity findById(Long id) {
        return baseRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        baseRepository.deleteById(id);
    }

    @Override
    public long count() {
        return baseRepository.count();
    }

    @Override
    public Entity save(Entity entity) {
        return baseRepository.save(entity);
    }

    @Override
    public Entity update(Entity entity) {
        return baseRepository.update(entity);
    }

    @Override
    public boolean existsById(Long id) {
        return baseRepository.existsById(id);
    }
}
