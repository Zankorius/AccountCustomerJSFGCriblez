/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.customeraccountjsf.bean;

import ch.hegarc.ig.odi.customeraccountjsf.business.Account;
import ch.hegarc.ig.odi.customeraccountjsf.service.BankService;
import javax.annotation.PostConstruct;
import javax.inject.Named;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author gary.criblez
 */
@Named(value = "accountBean")
@RequestScoped
public class AccountBean {

    @Inject
    BankService bs;
    
    private Account account;
    
    //on récupére le compte qui sera afficher
    @PostConstruct
    public void init() {
        account = bs.getAccEdit();
        
    }

    public BankService getBs() {
        return bs;
    }

    public void setBs(BankService bs) {
        this.bs = bs;
    }
    
    

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
    
}
