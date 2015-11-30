package ch.hegarc.ig.odi.customeraccountjsf.bean;


import ch.hegarc.ig.odi.customeraccountjsf.business.Customer;
import ch.hegarc.ig.odi.customeraccountjsf.service.BankService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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
    
    

    public BankService getBs() {
        return bs;
    }

    public void setBs(BankService bs) {
        this.bs = bs;
    }
    
    //récupération de la liste client
    @PostConstruct
    public void init(){
        customers = new ListDataModel<>();
        customers.setWrappedData(bs.getCustomersList());
    }
    
    
    public DataModel<Customer> getCustomers() {
        
        return customers;
    }
    
    public void setCustomers(DataModel<Customer> customers) {
        this.customers = customers;
    }
    
    public String add() {
        return "success";
    }
    
    //permet de rediriger sur la vue client en passant le client a afficher
    public String viewCustomer(Customer cust){
        bs.setCustEdit(cust);
        return "success";
    }
    
    
}
