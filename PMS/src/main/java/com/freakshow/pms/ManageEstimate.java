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
@Named("manageEst")
@SessionScoped
@Stateful
public class ManageEstimate implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;
    
    Estimate est = new Estimate();

    public Estimate getEst() {
        return est;
    }
    
    public String validateReWP(){
        return "create_estimate";
    }
    
    public void setEst(Estimate est) {
        this.est = est;
    }
    
    public void createReWP(){
        em.persist(est);
    }
    
}