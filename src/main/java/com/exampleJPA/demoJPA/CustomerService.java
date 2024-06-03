package com.exampleJPA.demoJPA;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
    //operations -
    public void addCustomer(Customer customer){
        repository.save(customer);
    }
    public void updateCustomer(Customer customer){
        repository.save(customer);
    }
    public void deleteCustomer(int id){
        repository.deleteById(id);
    }
    public List<Customer> getAllCustomers(){
        return repository.findAll();
    }
    public Customer getCustomerById(int id){
        Optional<Customer> customer = repository.findById(id);
        return repository.findById(id).orElse(null);
    }

}
