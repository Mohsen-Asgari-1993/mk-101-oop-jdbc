package ir.maktabsharif101.oopjdbc.base.service;

import ir.maktabsharif101.oopjdbc.base.domain.BaseEntity;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface BaseEntityService<T extends BaseEntity<ID>, ID extends Serializable> {

    List<T> findAll() throws SQLException;

    T findById(ID id) throws SQLException;

    void deleteById(ID id) throws SQLException;

    long count() throws SQLException;

    T save(T entity) throws SQLException;

    T update(T entity) throws SQLException;

    boolean existsById(ID id) throws SQLException;
}
