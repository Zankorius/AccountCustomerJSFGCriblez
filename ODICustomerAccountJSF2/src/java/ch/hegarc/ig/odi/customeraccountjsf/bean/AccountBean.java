/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.customeraccountjsf.bean;

import ch.hegarc.ig.odi.customeraccountjsf.business.Account;
import ch.hegarc.ig.odi.customeraccountjsf.service.BankService;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author gary.criblez
 */
@Named(value = "accountBean")
@Dependent
public class AccountBean {

    @Inject
    BankService bs;
    
    private Account account;
    
    public AccountBean() {
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
    
    public String viewAccount(Account acc){
        account = new Account();
        account = bs.getAccountByNumber(acc.getNumber());
        return "success";
    }
    
}
