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
/**
 * The Class ManageUser.
 */
@Named("manageProj")
@SessionScoped
@Stateful
public class ManageProject implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;
    
    @Inject 
    ManageUser emp;
    

    int projNo;
    Project proj = new Project();
    WorkPackage wp = new WorkPackage();
    Estimate est = new Estimate();
    List<Integer> availableProj;
    List<String> availableWP;
    List<String> reWP;    
    
    public Estimate getEst() {
        return est;
    }

    public void setEst(Estimate est) {
        this.est = est;
    }
 
    public ManageUser getEmp() {
        return emp;
    }

    public void setEmp(ManageUser emp) {
        this.emp = emp;
    } 
    
    public Project getProj() {
        return proj;
    }
    

    public void setProj(Project proj) {
        this.proj = proj;
    }
    

    public WorkPackage getWp() {
        return wp;
    }
    

    public void setWp(WorkPackage wp) {
        this.wp = wp;
    }    
    
    public List<String> getAvailableWP() { 
          TypedQuery<String> q = em.createQuery("SELECT wp_ID FROM WorkPackage WHERE proj_ID = :proj", String.class);
          q.setParameter("proj", projNo);
          availableWP =  q.getResultList();    
          return availableWP;
    }

    public void setAvailableWP(List<String> availableWP) {
        this.availableWP = availableWP;
    }
 
    public List<String> getReWP() {
        TypedQuery<String> q = em.createQuery("SELECT wp_ID FROM WorkPackage WHERE responsible_engineer = :re", String.class);
        q.setParameter("re", emp.getEmp().getEmp_ID());
        List<String> rwp =  (List<String>)q.getResultList();        
        return rwp;
    }

    public void setReWP(List<String> reWP) {
        this.reWP = reWP;
    }
    
    public List<Integer> getAvailableProj() {     
        TypedQuery<Integer> q = em.createQuery("SELECT proj_ID FROM Project", Integer.class);
        List<Integer> proj =  (List<Integer>)q.getResultList();      
        return proj;
    }

    public void setAvailableProj(List<Integer> availableProj) {       
        this.availableProj = availableProj;
    }
 

    public void handleProjChange(int proj) {  
        projNo = proj;
    } 
    
    public String verifyProj(){
        return "create_proj";
    }   
    
    public void createProj() {
        em.persist(proj);      
    }
    
    public void createWP() {
        em.persist(wp);      
    }
}