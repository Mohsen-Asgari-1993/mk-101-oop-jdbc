package ir.maktabsharif101.oopjdbc;

import ir.maktabsharif101.oopjdbc.domain.Customer;
import ir.maktabsharif101.oopjdbc.util.ApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class OopJdbcApplication {

    public static void main(String[] args) throws SQLException {


        ApplicationContext.getInstance().getCustomerService();


        createNewThreadAndCallCustomerServiceApi();
        createNewThreadAndCallCustomerServiceApi();
        createNewThreadAndCallCustomerServiceApi();
        createNewThreadAndCallCustomerServiceApi();
        createNewThreadAndCallCustomerServiceApi();

        List<Customer> customerList = ApplicationContext.getInstance().getCustomerService()
                .findAllByAgeBetween(18, 30);

        List<Customer> lessThan25 = customerList.stream().filter(customer -> customer.getAge() >= 18 && customer.getAge() < 25)
                .collect(Collectors.toList());
        List<Customer> greaterThan25 = customerList.stream().filter(customer -> customer.getAge() >= 25)
                .collect(Collectors.toList());
//        impl selectedCustomers

    }

    private static void createNewThreadAndCallCustomerServiceApi() {
        new Thread(
                () -> {
                    try {
                        ApplicationContext.getInstance().getCustomerService().testMultiThread();
                    } catch (InterruptedException ignore) {

                    }
                }
        ).start();
    }
}
