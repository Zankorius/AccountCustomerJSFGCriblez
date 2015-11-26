<%-- 
    Document   : welcomepage
    Created on : Nov 26, 2015, 5:35:03 PM
    Author     : gary.criblez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Facelet client-compte</title>
    </head>
    <body>
        
        <f:view>
            
            <h1><h:outputText value="#{resrc.pageName}"></h:outputText></h1>
            
            <br/><br/>
            
            <h:outputText id="hello" value="#{resrc.pageName}"></h:outputText>
            
            <br/><br/><br/>
      
            <h:outputLink value="faces/ajoutclientJSF.jsp" ><h:outputText value="#{resrc.adcli}"></h:outputText></h:outputLink>
      
            <br/><br/><br/>
      
            <h:outputLink value="faces/clientsJSF.jsp"><h:outputText value="#{resrc.cusList}"></h:outputText></h:outputLink>
            
            <br/><br/><br/>
            
            <h:form id="selectLangLink">
                <h:commandButton action="#{langBean.toEnglish}" image="ressources/en.jpg"></h:commandButton>
                <h:commandButton action="#{langBean.toFrench}"image="ressources/fr.png"></h:commandButton>
            </h:form>
            
            <h:form id="selectLangItem">
                <h:selectOneMenu onchange="submit()" valueChangeListener="#{langBean.langChange}">
                    <f:selectItem itemValue="1" itemLabel="FR"/>
                    <f:selectItem itemValue="2" itemLabel="EN"/>
                </h:selectOneMenu>
            </h:form>
            
        </f:view>
    </body>
</html>
