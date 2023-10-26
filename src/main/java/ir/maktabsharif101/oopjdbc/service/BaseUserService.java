package ir.maktabsharif101.oopjdbc.service;

import ir.maktabsharif101.oopjdbc.base.service.BaseEntityService;
import ir.maktabsharif101.oopjdbc.domain.User;

import java.sql.SQLException;

public interface BaseUserService<T extends User> extends BaseEntityService<T, Long> {

    T findByUsername(String username) throws SQLException;

    boolean existsByUsername(String username);

}
