package com.exampleJPA.demoJPA;

import org.springframework.data.repository.query.Param;
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
    public String getAllCustomers(Model model , @Param("Keyword") String keyword){
        List<Customer> customerList = customerService.getAllCustomers(keyword);
       model.addAttribute("customer" , customerList);
        model.addAttribute("keyword", keyword);
       return "viewCustomers";
    }
    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return "redirect:/all";
    }
    @RequestMapping("/Edit/{id}")
    public String editCustomer(@PathVariable int id , Model model){
        Customer c = customerService.getCustomerById(id);
        model.addAttribute("customer", c);
        return "EditCustomer";
    }
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/all";
    }


}
