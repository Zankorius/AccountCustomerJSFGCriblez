<%-- 
    Document   : ajoutclient
    Created on : Nov 25, 2015, 5:37:36 PM
    Author     : gary.criblez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <f:view locale="fr">
            <h1><h:outputText value="#{resrc.adcli}"></h:outputText></h1>
            
            <h:outputText value="#{resrc.pageName}"></h:outputText>
            
            
            
            <h:form id="addClient">    
                
                
                
                <h:panelGrid columns="3">
                                     <h:outputLabel for="nom" value="#{resrc.lastname} : "></h:outputLabel>
                    <h:inputText required="true" id="nom" value="#{customerBean.customer.lastname}" maxlength="50">
                        <f:validateLength minimum="2"/>
                    </h:inputText>
                    <h:message for="nom" showDetail="true" showSummary="true"/>
                    
                    <h:outputLabel for="prenom" value="#{resrc.firstname} : "></h:outputLabel>
                    <h:inputText required="true" id="prenom" value="#{customerBean.customer.firstname}" maxlength="50">
                        <f:validateLength minimum="2"/>
                    </h:inputText>
                    <h:message for="prenom" showDetail="true" showSummary="true"/>
                    
                </h:panelGrid>

                <h:commandButton rendered="#{customerBean.renderAdd}" action="#{customerBean.addCustomer}" id="ok" value="#{resrc.send}"></h:commandButton>
                <h:commandButton rendered="#{customerBean.renderEdi}" action="#{customerBean.editCustomer}" id="editcus" value="#{resrc.editCus}"></h:commandButton>
            </h:form>
            
        </f:view>
    </body>
</html>
