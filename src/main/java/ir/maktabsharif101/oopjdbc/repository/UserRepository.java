package ir.maktabsharif101.oopjdbc.repository;

import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;
import ir.maktabsharif101.oopjdbc.domain.User;

public interface UserRepository extends BaseEntityRepository {

    User findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByMobileName(String mobileName);

    User[] findAllByFirstNameAndLastName(String firstName, String LastName);
}