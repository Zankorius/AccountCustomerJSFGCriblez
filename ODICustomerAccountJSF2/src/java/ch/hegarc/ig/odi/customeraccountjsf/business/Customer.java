package ch.hegarc.ig.odi.customeraccountjsf.business;

import java.util.*;

public class Customer {

    Collection<Account> account;
    private int number;
    private String firstName;
    private String lastName;

    /**
     *
     * @param number
     * @param firstName
     * @param lastName
     */
    public Customer(Integer number, String firstName, String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = new ArrayList();

    }

    public Customer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param number
     */
    public Account getAccountByNumber(String number) {
        ArrayList<Account> parcours = (ArrayList<Account>) this.account;
        Account cible = null;
        Integer i = 0;
        while (cible == null & i < account.size()) {
            if (parcours.get(i).getNumber().equals(number)) {
                cible = parcours.get(i);
            }
        }
        return cible;

    }

    /**
     *
     * @param number
     * @param name
     * @param rate
     */
    public void addAccount(String number, String name, double rate) {
        Account nouveau = new Account(number, name, rate, this);
        this.account.add(nouveau);
    }

    public int getNumber() {
        return this.number;
    }

    /**
     *
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return this.firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
