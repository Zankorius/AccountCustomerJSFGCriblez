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
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Inject;

/**
 *
 * @author gary.criblez
 */

//bean pour la vue du client
@Named(value = "custBean")
@SessionScoped
public class CustomerBean implements Serializable {
    
    @Inject
    BankService bs;

    private Customer customer;
    
   
    //on récupére le client qui sera afficher et ses comptes
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
    
    //permet de rediriger sur la vue compte en passant le compte a afficher
    public String viewAccount(Account acc){
        bs.setAccEdit(bs.getAccountByNumber(acc.getNumber()));
        return "success";
    }   
    
    
    
    
    
}
