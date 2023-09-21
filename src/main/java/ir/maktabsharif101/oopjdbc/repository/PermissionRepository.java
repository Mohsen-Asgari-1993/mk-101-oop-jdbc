package ir.maktabsharif101.oopjdbc.repository;

import ir.maktabsharif101.oopjdbc.base.repository.BaseEntityRepository;
import ir.maktabsharif101.oopjdbc.domain.Permission;

public interface PermissionRepository extends BaseEntityRepository {

    Permission findByName(String name);

}
