package com.freakshow.pms;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named("availability")
@SessionScoped
@Stateful
public class ManageAvailability implements Serializable{
    Availability ava = new Availability();
    @PersistenceContext
    private EntityManager em;
    List<Integer> yourEmps;
    List<Integer> allProj;
    @Inject
    private ManageUser emp;
    
    public final Availability getAva(){
        return ava;
    }
    public final void setAva(Availability a){
        ava = a;
    }
    public List<Integer> getYourEmps(){
        TypedQuery<Integer> q = em.createQuery("SELECT emp_ID FROM Employee "
            + "WHERE supervisor_ID = :sup", Integer.class);
        q.setParameter("sup", emp.getEmp().getEmp_ID());
        yourEmps = (List<Integer>) q.getResultList();
        return yourEmps;
    }
    public final void setYourEmps(List<Integer> e){
        yourEmps = e;
    }
    public List<Integer> getAllProj(){
        TypedQuery<Integer> q = em.createQuery("SELECT proj_ID FROM Project", Integer.class);
        allProj = (List<Integer>) q.getResultList();
        return allProj;
    }
    public final void setAllProj(List<Integer> e){
        allProj = e;
    }
    /**
     * retrieves the current users employee object.
     * @return an employee object for the current user.
     */
    public final ManageUser getEmp() {
        return emp;
    }
    /**
     * sets the employee object.
     * @param e the new value to be assigned to emp.
     */
    public final void setEmp(final ManageUser e) {
        emp = e;
    }
    public final String assign(){
        em.persist("ava");
        return "emp_project";
    }
    
}
