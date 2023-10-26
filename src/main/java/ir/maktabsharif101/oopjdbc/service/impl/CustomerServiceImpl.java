package ir.maktabsharif101.oopjdbc.service.impl;

import ir.maktabsharif101.oopjdbc.domain.Customer;
import ir.maktabsharif101.oopjdbc.repository.CustomerRepository;
import ir.maktabsharif101.oopjdbc.service.CustomerService;
import ir.maktabsharif101.oopjdbc.service.RoleService;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

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

    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public synchronized void testMultiThread() throws InterruptedException {
        System.out.println(
                "in testMultiThread method : " + Thread.currentThread().getName() /*+ " --- " + "availablePermits: " + semaphore.availablePermits()*/
        );
//        semaphore.acquire();
        System.out.println(
                "start: " + Thread.currentThread().getName()
        );
        Thread.sleep(
                ThreadLocalRandom.current().nextInt(1000)
        );
        System.out.println(
                "end: " + Thread.currentThread().getName() /*+ " --- " + "availablePermits: " + semaphore.availablePermits()*/
        );
//        semaphore.release();
//        System.out.println(
//                "after release: " + Thread.currentThread().getName() + " --- " + "availablePermits: " + semaphore.availablePermits()
//        );
    }

    @Override
    public List<Customer> findAllByAgeBetween(Integer fromAge, Integer toAge) {
        return null;
    }
}
