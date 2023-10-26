package ir.maktabsharif101.oopjdbc.base.service.impl;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;
import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;
import ir.maktabsharif101.oopjdbc.base.service.BaseEntityService;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public class BaseEntityServiceImpl
        <T extends BaseEntity<ID>,
                ID extends Serializable,
                R extends BaseEntityRepository<T, ID>>
        implements BaseEntityService<T, ID> {

    protected final R baseRepository;

    public BaseEntityServiceImpl(R baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public List<T> findAll() throws SQLException {
        return baseRepository.findAll();
    }

    @Override
    public T findById(ID id) throws SQLException {
        return baseRepository.findById(id);
    }

    @Override
    public void deleteById(ID id) throws SQLException {
        baseRepository.deleteById(id);
    }

    @Override
    public long count() throws SQLException {
        return baseRepository.count();
    }

    @Override
    public T save(T entity) throws SQLException {
        return baseRepository.save(entity);
    }

    @Override
    public T update(T entity) throws SQLException {
        return baseRepository.update(entity);
    }

    @Override
    public boolean existsById(ID id) throws SQLException {
        return baseRepository.existsById(id);
    }
}
