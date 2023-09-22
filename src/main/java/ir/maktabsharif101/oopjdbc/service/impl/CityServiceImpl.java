package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.base.service.impl.BaseEntityServiceImpl;
import ir.maktabsharif101.oopjdbc.repository.CityRepository;
import ir.maktabsharif101.oopjdbc.service.CityService;

public class CityServiceImpl extends BaseEntityServiceImpl
        implements CityService {

    public CityServiceImpl(CityRepository baseRepository) {
        super(baseRepository);
    }

}
