package ir.maktabsharif101.oopjdbc.base.repository;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;

@SuppressWarnings("unused")
public interface BaseEntityRepository {

    BaseEntity[] findAll();

    BaseEntity findById(Long id);

    void deleteById(Long id);

    long count();

    BaseEntity save(BaseEntity entity);

    BaseEntity update(BaseEntity entity);

    boolean existsById(Long id);

}
