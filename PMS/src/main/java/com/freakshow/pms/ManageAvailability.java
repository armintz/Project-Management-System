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


    @PersistenceContext
    private EntityManager em;
    
    public Availability ava = new Availability();
    List<Integer> yourEmps;
    List<Integer> allProj;
    @Inject
    private ManageUser emp;
    
    public Availability getAva() {
        return ava;
    }
    public void setAva(Availability ava) {
        this.ava = ava;
    }
    
    public List<Integer> getYourEmps(){
        TypedQuery<Integer> q = em.createQuery("SELECT emp_ID FROM Employee "
            + "WHERE supervisor_ID = :sup", Integer.class);
        q.setParameter("sup", emp.getEmp().getEmp_ID());
        yourEmps = (List<Integer>) q.getResultList();
        return yourEmps;
    }
    public void setYourEmps(List<Integer> e){
        yourEmps = e;
    }
    public List<Integer> getAllProj(){
        TypedQuery<Integer> q = em.createQuery("SELECT proj_ID FROM Project", Integer.class);
        allProj = (List<Integer>) q.getResultList();
        return allProj;
    }
    public void setAllProj(List<Integer> e){
        allProj = e;
    }

    public ManageUser getEmp() {
        return emp;
    }

    public final void setEmp(final ManageUser e) {
        emp = e;
    }
    public String assign(){   
        try{
            em.persist(ava);
        }
        catch(Exception ex){
            System.out.println("problem with persisting avalibility" + ex);
        }
        return "assign_project";
    }
    
}
