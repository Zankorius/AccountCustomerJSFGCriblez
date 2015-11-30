package ch.hegarc.ig.odi.customeraccountjsf.bean;


import ch.hegarc.ig.odi.customeraccountjsf.business.Customer;
import ch.hegarc.ig.odi.customeraccountjsf.service.BankService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;


import javax.faces.model.*;
import javax.inject.Inject;
import javax.inject.Named;

//bean pour gérer la liste des clients

@Named(value="listCustomerBean")
@RequestScoped
public class CustomersBean implements Serializable{
    
    @Inject
    BankService bs;

    private DataModel<Customer> customers;
    
    public CustomersBean() {
        
    }

    public BankService getBs() {
        return bs;
    }

    public void setBs(BankService bs) {
        this.bs = bs;
    }
    
    
    
    public DataModel<Customer> getCustomers() {
        customers = new ListDataModel<>();
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
