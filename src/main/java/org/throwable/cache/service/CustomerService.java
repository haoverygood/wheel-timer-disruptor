package org.throwable.cache.service;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.throwable.cache.entity.Customer;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/6/19 17:20
 */
@Service
public class CustomerService {

    @Cacheable(value = "customer-key", key = "'customer-key#' + #id")
    public Customer getCustomerById(Long id) {
        System.out.println("模拟数据库查询Customer实体");
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("zjc" + id);
        customer.setAge(24);
        return customer;
    }

    //这里注意一点@CachePut只会拦截方法的返回值作为更新的基准
    @CachePut(value = "customer-key", key = "'customer-key#' + #customer.id")
    public Customer updateCustomer(Customer customer) {
        System.out.println("模拟更新customer -->" + customer);
        return customer;
    }
}
