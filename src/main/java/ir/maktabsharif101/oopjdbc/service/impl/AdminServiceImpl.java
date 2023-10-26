package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.domain.Admin;
import ir.maktabsharif101.oopjdbc.repository.AdminRepository;
import ir.maktabsharif101.oopjdbc.service.AdminService;
import ir.maktabsharif101.oopjdbc.service.RoleService;

@SuppressWarnings("unused")
public class AdminServiceImpl
        extends BaseUserServiceImpl<Admin, AdminRepository>
        implements AdminService {

    public AdminServiceImpl(AdminRepository baseRepository, RoleService roleService) {
        super(baseRepository, roleService);
    }
}
