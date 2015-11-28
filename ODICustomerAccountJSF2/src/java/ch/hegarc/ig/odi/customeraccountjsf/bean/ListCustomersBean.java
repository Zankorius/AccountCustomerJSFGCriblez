package ch.hegarc.ig.odi.customeraccountjsf.bean;


import ch.hegarc.ig.odi.customeraccountjsf.business.Customer;
import ch.hegarc.ig.odi.customeraccountjsf.service.BankService;
import ch.hegarc.ig.odi.customeraccountjsf.service.Tools;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

import javax.faces.model.*;
import javax.inject.Named;

//bean pour gérer la liste des clients

@Named(value="listCustomerBean")
@SessionScoped
public class ListCustomersBean implements Serializable{

    private DataModel<Customer> customers;
    
    public ListCustomersBean() {
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
    
    public String edit(Customer customer) {
        AddCustomerBean editCusomerBean = Tools.findBean("customerBean", AddCustomerBean.class);
        editCusomerBean.setCustomer(customer);
        editCusomerBean.setRenderAdd(false);
        editCusomerBean.setRenderEdi(true);
        return "edit";
    }
    
    
}
