package ch.hegarc.ig.odi.customeraccountjsf.service;

import ch.hegarc.ig.odi.customeraccountjsf.business.Account;
import ch.hegarc.ig.odi.customeraccountjsf.business.Bank;
import ch.hegarc.ig.odi.customeraccountjsf.business.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

/**
 * Classe de services qui stocke les données de l'application dans la session de
 * l'utilisateur. Cette classe est gérée par CDI et peut donc être injectée dans
 * les autres classes Java.
 *
 * @author julien.plumez
 */
@SessionScoped
@Stateful
public class BankService implements Serializable {

    private Bank bank;
    //sert pour récupérer le client pour la vue
    private Customer custEdit = null;
    // sert pour récupérer le compte pour la vue
    private Account accEdit = null;
   

    public BankService() {
        bank = new Bank(1, "Raiffeisen Neuchâtel");

        Customer cust = bank.addCustomer(1, "Jean", "Dupont");

        bank.addAccount("1", "Salaire", 0.001, cust);
        bank.addAccount("2", "Impots", 0.002, cust);

        cust = bank.addCustomer(2, "Marie", "Dupont");
        bank.addAccount("3", "Epargne", 0.002, cust);
        bank.addAccount("4", "Salaire", 0.001, cust);
    }

    /**
     * Dit à la banque de créer un nouveau client.
     *
     * @param number Le numéro unique du client
     * @param fn Le prénom du client
     * @param ln Le nom du client
     */
    public void saveCustomer(Integer number, String fn, String ln) {
        bank.addCustomer(number, fn, ln);
    }

    /**
     * Retourne le client de la banque qui correspond au numéro passé en
     * paramètre.
     *
     * @param number Le numéro du client à rechercher
     * @return Le client, ou null s'il n'est pas trouvé
     */
    public Customer getCustomer(Integer number) {
        return bank.getCustomerByNumber(number);
    }

    /**
     * Retourne une Map contenant tous les clients de la banqe
     *
     * @return Une Map contenant tous les clients de la banqe
     */
    public Map<Integer, Customer> getCustomers() {
        return bank.getCustomers();
    }

    /**
     * Retourne une List contenant tous les clients de la banque. Utile pour
     * l'affichage des clients dans les facelets
     *
     * @return Une List contenant tous les clients de la banque.
     */
    public List<Customer> getCustomersList() {
        return new ArrayList(getCustomers().values());
    }

    /**
     * Retourne une Collection<Account> des comptes appartenant au client
     * indiqué en paramètre.
     *
     * @param customer Le client duquel il faut retourner les comptes
     * @return Une Collection<Account> de comptes
     */
    public Collection<Account> getAccountsByCustomer(Customer customer) {
        return bank.getAccountsByCustomer(customer);
    }
    
    //récupération d'un compte par son id
    public Account getAccountByNumber(String number){
        return bank.getAccountByNumber(number);
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Customer getCustEdit() {
        return custEdit;
    }

    public void setCustEdit(Customer custEdit) {
        this.custEdit = custEdit;
    }

    public Account getAccEdit() {
        return accEdit;
    }

    public void setAccEdit(Account accEdit) {
        this.accEdit = accEdit;
    }

    
    
   

    
}
