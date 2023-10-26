package ir.maktabsharif101.oopjdbc.repository.impl;

import ir.maktabsharif101.oopjdbc.domain.Customer;
import ir.maktabsharif101.oopjdbc.repository.CustomerRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepositoryImpl extends BaseUserRepositoryImpl<Customer>
        implements CustomerRepository {

    protected CustomerRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getEntityTableName() {
        return Customer.TABLE_NAME;
    }

    @Override
    protected Customer getNewUserInstance() {
        return new Customer();
    }

    @Override
    protected Customer mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Customer customer = super.mapResultSetToEntity(resultSet);
        customer.setEmail(
                resultSet.getString(8)
        );
        customer.setAddress(
                resultSet.getString(9)
        );
        return customer;
    }
}
