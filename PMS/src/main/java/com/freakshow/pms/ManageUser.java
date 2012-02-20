package com.freakshow.pms;

import java.io.Serializable;
import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * The Class ManageUser.
 */
@Named("manageUser")
@RequestScoped
@Stateful
public class ManageUser implements Serializable {
    
    @PersistenceContext 
    protected EntityManager em;
    @Inject
    UserBean ub = new UserBean();
    void persist(){
        em.persist(ub);
        em.flush();
    }
    public String verifyUser(){
        /*
        Query query = em.createQuery("from " +
                "Employee e where userName=admin");
        ub = (UserBean)query.getSingleResult();
        */
        return "login";
    }     
}