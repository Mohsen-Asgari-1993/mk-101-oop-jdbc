package ir.maktabsharif101.oopjdbc.service;

import ir.maktabsharif101.oopjdbc.base.service.BaseEntityService;
import ir.maktabsharif101.oopjdbc.domain.User;

import java.sql.SQLException;

public interface UserService extends BaseEntityService<User, Long> {

    User findByUsername(String username) throws SQLException;

    boolean existsByUsername(String username);

    boolean existsByMobileNumber(String mobileName);
}
