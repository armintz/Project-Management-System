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
@Named("manageProj")
@SessionScoped
@Stateful
public class ManageProject implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;
    
    Project proj = new Project();

    public Project getProj() {
        return proj;
    }

    public void setProj(Project proj) {
        this.proj = proj;
    }

    public String verifyProj(){
        return "create_proj";
    }   
    
    public void createProj() {
        em.persist(proj);      
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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Welcome Employee", "Employee Successfully Created!"));  
    } 
}