package com.telusko.crm_application.service;

import com.telusko.crm_application.entity.Customer;
import com.telusko.crm_application.repo.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private ICustomerRepo repo;

    @Autowired
    public void setRepo(ICustomerRepo repo) {
        this.repo = repo;
    }


    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>)repo.findAll();
    }

    @Override
    public void registerCustomer(Customer customer) {
        repo.save(customer);

    }

    @Override
    public void deleteCustomer(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
