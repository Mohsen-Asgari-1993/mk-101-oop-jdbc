package ir.maktabsharif101.oopjdbc.service;

import ir.maktabsharif101.oopjdbc.base.service.BaseEntityService;
import ir.maktabsharif101.oopjdbc.domain.Permission;

public interface PermissionService extends BaseEntityService {

    Permission findByName(String name);

}
