package ir.maktabsharif101.oopjdbc.base.repository;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;

import java.sql.SQLException;

@SuppressWarnings("unused")
public interface BaseEntityRepository {

    BaseEntity[] findAll() throws SQLException;

    BaseEntity findById(Long id) throws SQLException;

    void deleteById(Long id);

    long count() throws SQLException;

    BaseEntity save(BaseEntity entity);

    BaseEntity update(BaseEntity entity);

    boolean existsById(Long id);

}
