package org.throwable.cache.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.throwable.Application;
import org.throwable.cache.entity.Customer;

import static org.junit.Assert.*;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/19 17:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testCache() throws Exception {
        Customer customer = customerService.getCustomerById(10086L);
        customerService.getCustomerById(11111L);
        System.out.println("第一次查询结果:" + customer);
        customer = customerService.getCustomerById(10086L);
        System.out.println("第二次查询结果:" + customer);
        customer.setAge(233);
        customer.setName("doge");
        customerService.updateCustomer(customer);
        customer = customerService.getCustomerById(10086L);
        System.out.println("第三次查询结果:" + customer);
    }

}