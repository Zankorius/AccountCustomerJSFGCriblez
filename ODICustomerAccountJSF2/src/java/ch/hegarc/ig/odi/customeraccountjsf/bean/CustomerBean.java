/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.customeraccountjsf.bean;

import ch.hegarc.ig.odi.customeraccountjsf.business.Account;
import ch.hegarc.ig.odi.customeraccountjsf.business.Customer;
import ch.hegarc.ig.odi.customeraccountjsf.service.BankService;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;

/**
 *
 * @author gary.criblez
 */
@Named(value = "custBean")
@RequestScoped
public class CustomerBean implements Serializable {
    
    @Inject
    BankService bs;

    private Customer customer;
    
   
    
    
    public CustomerBean() {
        customer = new Customer();
    }

    public BankService getBs() {
        return bs;
    }

    public void setBs(BankService bs) {
        this.bs = bs;
    }
    
    
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }

    public void getAccounts() {
         customer.setAccounts(bs.getAccountsByCustomer(customer));
    }

 
    
    public String addCustomer() {
        
        
        bs.saveCustomer(bs.getCustomersList().size()+1, customer.getFirstName(), customer.getLastName());
        
        return "success";
        
    }
    
    public String viewCustomer(Customer cust){
        customer = new Customer();
        customer = bs.getCustomer(cust.getNumber());
        return "success";
    }
    
    
    
    
    
}
