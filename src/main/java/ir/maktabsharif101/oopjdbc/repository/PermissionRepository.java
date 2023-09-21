package ir.maktabsharif101.oopjdbc.repository;

import ir.maktabsharif101.oopjdbc.domain.Permission;

public interface PermissionRepository {

    Permission[] findAll();

    Permission findById(Long id);

    Permission save(Permission role);

    Permission update(Permission role);
}
