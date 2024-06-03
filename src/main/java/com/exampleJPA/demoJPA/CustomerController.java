package com.exampleJPA.demoJPA;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //requests
    //Get mapping
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/Register")
    public String register() {
        return "RegisterCustomer";
    }

    @GetMapping("/all")
    public ModelAndView getCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ModelAndView("customerList","customer",customers);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping("/save")
    public String addCustomer(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/all";
    }

    @RequestMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "redirect:/all";
    }

    @RequestMapping("/Edit/{id}")
    public String updateCustomer(@PathVariable int id,
                               Model model) {
      Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "EditCustomer";
    }

}
