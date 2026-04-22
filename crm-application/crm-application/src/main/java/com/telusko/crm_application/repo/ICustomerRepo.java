package com.telusko.crm_application.repo;

import com.telusko.crm_application.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

}
