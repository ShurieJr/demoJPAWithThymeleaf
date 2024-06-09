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
    public String getHomePage(){
        return "home"; // view name
    }
    @GetMapping("/Register")
    public String getRegisterPage(){
        return "RegisterCustomer"; // view name
    }
    @RequestMapping("/all")
    public ModelAndView getAllCustomers(){
        List<Customer> customerList = customerService.getAllCustomers();
        return new ModelAndView("viewCustomers",
                "customer" , customerList);
    }
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return "redirect:/all";
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/all";
    }


}
