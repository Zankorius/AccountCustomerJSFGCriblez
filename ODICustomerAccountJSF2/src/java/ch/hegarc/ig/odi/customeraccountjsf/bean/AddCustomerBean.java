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
@Named(value = "addCustomerBean")
@SessionScoped
public class AddCustomerBean implements Serializable{
    
    private Customer customer;
    private boolean renderAdd; 
    private boolean renderEdi;
    
    public AddCustomerBean() {
        customer = new Customer();
        renderAdd = true;
        renderEdi = false;
    }
    
    
    public boolean getRenderAdd() {
        return this.renderAdd;
    }
    
    public void setRenderAdd(boolean renderAdd) {
        this.renderAdd = renderAdd;
    }
    
    public boolean getRenderEdi() {
        return this.renderEdi;
    }
    
    public void setRenderEdi(boolean renderEdi){
        this.renderEdi = renderEdi;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Customer getCustomer() {
        return this.customer;
    }
    
    public void addCustomer() {
        System.out.println("Catch de l'ajout");
        BankService bs = new BankService();
        bs.saveCustomer(customer.getNumber(), customer.getFirstName(), customer.getLastName());
        System.out.println("BANK REGISTRY\r\n" + bs.toString());
    }
    
    
}
