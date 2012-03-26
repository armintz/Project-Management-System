package com.freakshow.pms;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
}