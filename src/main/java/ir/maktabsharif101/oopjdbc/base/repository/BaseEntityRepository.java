package ir.maktabsharif101.oopjdbc.base.repository;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;

import java.sql.SQLException;

@SuppressWarnings("unused")
public interface BaseEntityRepository {

    BaseEntity[] findAll() throws SQLException;

    BaseEntity findById(Long id) throws SQLException;

    void deleteById(Long id);

    long count() throws SQLException;

    BaseEntity save(BaseEntity entity) throws SQLException;

    BaseEntity update(BaseEntity entity) throws SQLException;

    boolean existsById(Long id) throws SQLException;

}
