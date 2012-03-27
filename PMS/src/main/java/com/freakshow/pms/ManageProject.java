package com.freakshow.pms;

import java.io.Serializable;
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
@Named("manageProj")
@SessionScoped
@Stateful
public class ManageProject implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;
    
    Project proj = new Project();
    WorkPackage wp = new WorkPackage();
    List<Integer> availableProj;
    
    public List<Integer> getAvailableProj() {     
        TypedQuery<Integer> q = em.createQuery("SELECT proj_ID FROM Project", Integer.class);
        List<Integer> proj =  (List<Integer>)q.getResultList();      
        return proj;
    }

    public void setAvailableProj(List<Integer> availableProj) {
       
        this.availableProj = availableProj;
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