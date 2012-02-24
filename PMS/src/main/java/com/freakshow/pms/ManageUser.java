package com.freakshow.pms;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.faces.event.ActionEvent;  
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;  
/**
 * The Class ManageUser.
 */
@Named("manageUser")
@SessionScoped
@Stateful
public class ManageUser implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;
    Employee emp = new Employee();
    
    public Employee getUser() {
        return emp;
    }

    public void setUser(Employee user) {
        this.emp = user;
    }
   
    public String verifyUser(){
        /*
        Query query = em.createQuery("from " +
                "Employee e where userName=admin");
        ub = (UserBean)query.getSingleResult();
        */
        return "login";
    }   
    
    public void createUser() {

        em.persist(emp);
    }
    public void save(ActionEvent actionEvent) {  
        addMessage("Data saved");  
    }  
      
    public void update(ActionEvent actionEvent) {  
        addMessage("Data updated");  
    }  
      
    public void delete(ActionEvent actionEvent) {  
        addMessage("Data deleted");  
    }  
      
    public void addMessage(String summary) {  
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }    
    public void addInfo(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Welcome Employee", "You have been added to a new project!"));  
    } 
}