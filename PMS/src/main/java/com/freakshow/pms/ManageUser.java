package com.freakshow.pms;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
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
    Date end_date;

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
    
    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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
        return "login";
    }   
    
    public void createUser() {
        em.persist(tempEmp);
    }
    
    public boolean showMenuEmployee(){     
        return emp.isRole_HR();
    }    
    
    public boolean showMenuProject(){     
        return emp.isRole_PM();
    }   
    
    public boolean showMenuSupervisor(){     
        return emp.isRole_Supervisor();
    }
    
    public boolean showMenuCreateProject(){     
        return emp.isRole_create_Proj();
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
    
    public String removeEmp(int selectedEmpID) {
        tempEmp = em.find(Employee.class, selectedEmpID);
        tempEmp.setEmp_end_date(end_date);
        em.merge(tempEmp);
        em.flush();
        return "remove_emp";
    }    
    
    public void updateEmp() {
        em.merge(tempEmp);
        em.flush();
    }
    
    public void createPlevel(){
        em.persist(pL);
    }
       
    public boolean showMenuRe(){
        TypedQuery<WorkPackage> q = em.createQuery("SELECT w FROM WorkPackage w WHERE w.responsible_engineer = :re", WorkPackage.class);
        q.setParameter("re", emp.getEmp_ID());
        if(q.getResultList() != null){
            return true;
        }
        else
            return false;                    
    }
}