package ir.maktabsharif101.oopjdbc.repository;

import ir.maktabsharif101.oopjdbc.domain.Role;

public interface RoleRepository {

    Role[] findAll();

    Role findById(Long id);

    Role save(Role role);

    Role update(Role role);
}
