package ch.hegarc.ig.odi.customeraccountjsf.bean;


import ch.hegarc.ig.odi.customeraccountjsf.business.Customer;
import ch.hegarc.ig.odi.customeraccountjsf.service.BankService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import javax.faces.model.*;
import javax.inject.Named;

//bean pour gérer la liste des clients

@Named(value="listCustomerBean")
@SessionScoped
public class CustomersBean implements Serializable{

    private DataModel<Customer> customers;
    
    public CustomersBean() {
        
    }
    
    public DataModel<Customer> getCustomers() {
        customers = new ListDataModel<>();
        BankService bs = new BankService();
        customers.setWrappedData(bs.getCustomersList());
        return customers;
    }
    
    public void setCustomers(DataModel<Customer> customers) {
        this.customers = customers;
    }
    
    public String add() {
        return "success";
    }
    
    
    
    
}
