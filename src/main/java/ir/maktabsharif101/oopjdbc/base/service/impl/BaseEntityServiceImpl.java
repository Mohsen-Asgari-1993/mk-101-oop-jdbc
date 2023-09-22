package ir.maktabsharif101.oopjdbc.base.service.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;
import ir.maktabsharif101.oopjdbc.base.service.BaseEntityService;

import java.sql.SQLException;

public class BaseEntityServiceImpl implements BaseEntityService {

    protected final BaseEntityRepository baseRepository;

    public BaseEntityServiceImpl(BaseEntityRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public BaseEntity[] findAll() throws SQLException {
        return baseRepository.findAll();
    }

    @Override
    public BaseEntity findById(Long id) throws SQLException {
        return baseRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        baseRepository.deleteById(id);
    }

    @Override
    public long count() throws SQLException {
        return baseRepository.count();
    }

    @Override
    public BaseEntity save(BaseEntity entity) {
        return baseRepository.save(entity);
    }

    @Override
    public BaseEntity update(BaseEntity entity) {
        return baseRepository.update(entity);
    }

    @Override
    public boolean existsById(Long id) throws SQLException {
        return baseRepository.existsById(id);
    }
}
