package ch.hegarc.ig.odi.customeraccountjsf.service;

import javax.faces.context.FacesContext;

public class Tools {
    public static <T> T findBean(String name, Class<T> beanClass) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        return beanClass.cast(facesContext.getApplication().evaluateExpressionGet(facesContext, "#{" + name + "}", beanClass));
    }
}