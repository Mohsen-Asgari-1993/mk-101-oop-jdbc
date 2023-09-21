package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.base.service.impl.BaseEntityServiceImpl;
import ir.maktabsharif101.oopjdbc.domain.Permission;
import ir.maktabsharif101.oopjdbc.repository.PermissionRepository;
import ir.maktabsharif101.oopjdbc.service.PermissionService;

@SuppressWarnings("unused")
public class PermissionServiceImpl extends BaseEntityServiceImpl
        implements PermissionService {

    public PermissionServiceImpl(PermissionRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Permission findByName(String name) {
        return ((PermissionRepository) baseRepository).findByName(name);
    }

}
