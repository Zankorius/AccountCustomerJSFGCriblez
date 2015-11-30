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
import javax.annotation.PostConstruct;
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
    
   
    
    @PostConstruct
    public void init() {
        customer = bs.getCustEdit();
        customer.setAccounts(bs.getAccountsByCustomer(customer));
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
    
    public String viewAccount(Account acc){
        bs.setAccEdit(bs.getAccountByNumber(acc.getNumber()));
        return "success";
    }   
    
    
    
    
    
}
