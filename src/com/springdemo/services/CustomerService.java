package com.springdemo.services;

import java.util.List;

import com.springdemo.entity.Customer;

public interface CustomerService {
 public List<Customer> getCustomers();

public void saveCustomer(Customer theCustomer);

public Customer getCustomer(int theId);

public Customer deleteCustomer(int theId);
}
