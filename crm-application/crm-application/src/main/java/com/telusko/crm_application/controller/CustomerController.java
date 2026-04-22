package com.telusko.crm_application.controller;

import com.telusko.crm_application.entity.Customer;
import com.telusko.crm_application.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    private ICustomerService service;

    @Autowired
    public void setService(ICustomerService service) {
        this.service = service;
    }

//    List-Customers
    @GetMapping("/customerlist")
    public String getAllCustomers(Model model){
       List<Customer> customers =  service.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customerlist";
    }

    //    Show Form
    @GetMapping("/showCustomerForm")
    public String showFrom(@ModelAttribute("customer") Customer customer){
        return "customerform";
    }

    //    Update Form
    @GetMapping("/updateCustomerForm")
    public String updateFrom(@RequestParam("id") Integer id, Model model){
        Customer customer = service.getCustomerById(id);
        if (customer == null) {
            // Optional: Handle case where customer not found (e.g., redirect with error)
            return "redirect:/customerlist";
        }
        model.addAttribute("customer", customer);
        return "customerform";
    }

    // Register Customer
    @PostMapping("/registerCustomer")
    public  String registerCustomer(@ModelAttribute("customer") Customer customer){
        service.registerCustomer(customer);
        return "redirect:/customerlist";
    }

    //    Update Form
    @GetMapping("/deleteCustomer")
    public String deleteCustomerById(@RequestParam("id") Integer id){
        service.deleteCustomer(id);
        return "redirect:/customerlist";
    }



}
