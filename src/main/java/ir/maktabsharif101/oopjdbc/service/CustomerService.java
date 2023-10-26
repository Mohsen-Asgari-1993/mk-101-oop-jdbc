package ir.maktabsharif101.oopjdbc.service;

import ir.maktabsharif101.oopjdbc.domain.Customer;

import java.util.List;

public interface CustomerService extends BaseUserService<Customer> {


    void testMultiThread() throws InterruptedException;


    List<Customer> findAllByAgeBetween(Integer fromAge, Integer toAge);

}
