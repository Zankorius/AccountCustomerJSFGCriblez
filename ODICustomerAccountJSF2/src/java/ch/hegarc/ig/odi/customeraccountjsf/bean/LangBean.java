/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hegarc.ig.odi.customeraccountjsf.bean;

import java.io.Serializable;
import java.util.Locale;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author gary.criblez
 */

//bean qui permet de modifier la langue dans la page

@Named(value = "langBean")
@SessionScoped
public class LangBean implements Serializable{
    public LangBean() {}
    
    public void toFrench(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.FRENCH);
    }
    
    public void toEnglish(){
        FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.ENGLISH);
    }
    
    public void langChange(ValueChangeEvent val) {
        String newLang = (String)val.getNewValue();
        if (newLang.equals("1"))
            toFrench();
        else if (newLang.equals("2"))
            toEnglish();
    }
}
