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

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public String verifyUser(){
        try{            
            Employee temp_emp = em.find(Employee.class, emp.getEmp_ID());
            if(temp_emp.getEmp_pass().equals(emp.getEmp_pass())){
                emp = temp_emp;
                return "employee";
            }
        }
        catch(Exception ex){
            System.out.println("No employee in record.");
        }
        return "create_emp";
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
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Welcome Employee", "Employee Successfully Created!"));  
    } 
}