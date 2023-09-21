package ir.maktabsharif101.oopjdbc.base.service;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;

public interface BaseEntityService {

    BaseEntity[] findAll();

    BaseEntity findById(Long id);

    void deleteById(Long id);

    long count();

    BaseEntity save(BaseEntity entity);

    BaseEntity update(BaseEntity entity);

    boolean existsById(Long id);
}
