package com.freakshow.pms;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
    Employee tempEmp = new Employee();
    Plevel pL = new Plevel();
    
    List<Integer> availableEmp;
    
    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }
    
    public Employee getTempEmp() {
        return tempEmp;
    }

    public void setTempEmp(Employee tempEmp) {
        this.tempEmp = tempEmp;
    }
    
    public Plevel getpL() {
        return pL;
    }

    public void setpL(Plevel pL) {
        this.pL = pL;
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
        em.persist(tempEmp);
    }
    
    public boolean showMenuEmployee(){     
        return emp.isRole_HR();
    }    
    public boolean showMenuWP(){     
        return emp.isRole_create_WP();
    }
    public boolean showMenuProject(){     
        return emp.isRole_Supervisor();
    }   
    
    public List<Integer> getAvailableEmp() {     
        TypedQuery<Integer> q = em.createQuery("SELECT emp_ID FROM Employee", Integer.class);
        List<Integer> emps =  (List<Integer>)q.getResultList();      
        return emps;
    }

    public void setAvailableEmp(List<Integer> availableEmp) {       
        this.availableEmp = availableEmp;
    }
    
    public String editEmp(int selectedEmpID) {
        tempEmp = em.find(Employee.class, selectedEmpID);
        return "edit_emp_details";
    }
    
    public void updateEmp() {
        em.merge(tempEmp);
        em.flush();
    }
    
    public void createPlevel(){
        em.persist(pL);
    }
    
}