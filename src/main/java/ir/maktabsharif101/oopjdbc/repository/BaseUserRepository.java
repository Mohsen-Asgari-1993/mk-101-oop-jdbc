package ir.maktabsharif101.oopjdbc.repository;

import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;
import ir.maktabsharif101.oopjdbc.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface BaseUserRepository<T extends User> extends BaseEntityRepository<T, Long> {

    T findByUsername(String username) throws SQLException;

    List<T> findAllByMobileNumber(String mobileNumber);

    boolean existsByUsername(String username);

    boolean existsByMobileNumber(String mobileNumber);

}
