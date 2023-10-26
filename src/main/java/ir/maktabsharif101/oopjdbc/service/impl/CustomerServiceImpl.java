package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.domain.Customer;
import ir.maktabsharif101.oopjdbc.repository.CustomerRepository;
import ir.maktabsharif101.oopjdbc.service.CustomerService;
import ir.maktabsharif101.oopjdbc.service.RoleService;

import java.sql.SQLException;

@SuppressWarnings("unused")
public class CustomerServiceImpl
        extends BaseUserServiceImpl<Customer, CustomerRepository>
        implements CustomerService {

    public CustomerServiceImpl(CustomerRepository baseRepository, RoleService roleService) {
        super(baseRepository, roleService);
    }

    @Override
    public Customer save(Customer entity) throws SQLException {
        return super.save(entity);
    }
}
