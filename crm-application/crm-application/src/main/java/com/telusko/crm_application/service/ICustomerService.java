package com.telusko.crm_application.service;

import com.telusko.crm_application.entity.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> getAllCustomers();
    public void registerCustomer(Customer customer);
    public void deleteCustomer(Integer id);
    public Customer getCustomerById(Integer id);


}
