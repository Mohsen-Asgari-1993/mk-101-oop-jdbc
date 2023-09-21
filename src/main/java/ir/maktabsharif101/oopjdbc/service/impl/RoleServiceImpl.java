package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.base.domain.Entity;
import ir.maktabsharif101.oopjdbc.base.service.impl.BaseEntityServiceImpl;
import ir.maktabsharif101.oopjdbc.repository.RoleRepository;
import ir.maktabsharif101.oopjdbc.service.RoleService;

@SuppressWarnings("unused")
public class RoleServiceImpl
        extends BaseEntityServiceImpl
        implements RoleService {

    public RoleServiceImpl(RoleRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Entity save(Entity entity) {
        System.out.println("");
        return super.save(entity);
    }
}
