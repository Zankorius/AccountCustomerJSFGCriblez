/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.customeraccountjsf.bean;

import ch.hegarc.ig.odi.customeraccountjsf.service.BankService;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author gary.criblez
 */
@Named(value = "addCustomerBean")
@RequestScoped
public class addCustomerBean {

    @Inject
    BankService bs;
    
    private Integer number = null;
    private String lastName = null;
    private String firstName = null;
    
    public addCustomerBean() {
    }

    public BankService getBs() {
        return bs;
    }

    public void setBs(BankService bs) {
        this.bs = bs;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String addCustomer() {
        
        
        bs.saveCustomer(bs.getCustomersList().size()+1, firstName, lastName);
        
        return "success";
        
    }
    
}
