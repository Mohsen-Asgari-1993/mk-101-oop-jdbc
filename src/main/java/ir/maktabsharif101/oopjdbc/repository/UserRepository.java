package ir.maktabsharif101.oopjdbc.repository;

import ir.maktabsharif101.oopjdbc.domain.User;

public interface UserRepository {

    User[] findAll();

    User findById(Long id);

    void deleteById(Long id);

    User save(User user);

    User update(User user);

    long count();
}