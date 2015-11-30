/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.customeraccountjsf.bean;

import ch.hegarc.ig.odi.customeraccountjsf.business.Customer;
import ch.hegarc.ig.odi.customeraccountjsf.service.BankService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author gary.criblez
 */
@Named(value = "custBean")
@SessionScoped
public class CustomerBean implements Serializable {

    private Customer customer;
    
    
    public CustomerBean() {
        customer = new Customer();
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    
    public String addCustomer() {
        
        BankService bs = new BankService();
        bs.saveCustomer(customer.getNumber(), customer.getFirstName(), customer.getLastName());
        
        return "success";
        
    }
    
    public String viewCustomer(Customer cust){
        setCustomer(cust);
        return "success";
    }
    
    
}
