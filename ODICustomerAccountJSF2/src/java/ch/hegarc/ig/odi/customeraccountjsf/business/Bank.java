/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.customeraccountjsf.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author gary.criblez
 */
public class Bank {

    private int number;
    private String name;
    private List<Customer> customers;
    private List<Account> accounts;

    public Bank(int number, String name) {
        this.number = number;
        this.name = name;
        this.customers = new ArrayList();
        this.accounts = new ArrayList();
    }

    public Account getAccountByNumber(String number) {
        Account cible = null;
        Integer i = 0;
        while (cible == null & i < accounts.size()) {
            if (accounts.get(i).getNumber().equals(number)) {
                cible = accounts.get(i);
            }
        }
        return cible;

    }

    public Customer getCustomerByNumber(int number) {
        Customer cible = null;
        Integer i = 0;
        while (cible == null & i < customers.size()) {
            if (customers.get(i).getNumber() == number) {
                cible = customers.get(i);
            }
        }
        return cible;
    }

    public Customer addCustomer(int number, String fn, String ln) {
        Customer cust = new Customer(number, fn, ln);
        customers.add(cust);

        return cust;
    }

    public void addAccount(String number, String name, double rate, Customer customer) {
        Account acc = new Account(number, name, rate, customer);
        accounts.add(acc);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Customer> getCustomers() {
        HashMap<Integer, Customer> customers1 = new HashMap();
        for (Customer cust : customers) {
            Integer num = cust.getNumber();
            customers1.put(num, cust);
        }
        return customers1;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Collection<Account> getAccountsByCustomer(Customer customer) {
        Collection<Account> accountsByCustomer = new ArrayList<>();
        for (Account account : accounts) {
            if (account.customer.getNumber() == customer.getNumber()) {
                accountsByCustomer.add(account);
            }
        }
        return accountsByCustomer;
    }

}
