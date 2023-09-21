package ir.maktabsharif101.oopjdbc.service;

import ir.maktabsharif101.oopjdbc.base.service.BaseEntityService;
import ir.maktabsharif101.oopjdbc.domain.User;

public interface UserService extends BaseEntityService {

    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByMobileNumber(String mobileName);
}
