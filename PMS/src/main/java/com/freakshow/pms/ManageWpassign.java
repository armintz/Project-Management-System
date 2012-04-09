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
 * class for managing the assignment of employees to work packages.
 * @author Joe
 *
 */
@Named("wpassign")
@SessionScoped
@Stateful
public class ManageWpassign implements Serializable{
    /**
     * the entity.
     */
    private Wpassign wpa = new Wpassign();
    /**
     * entity manager so we can query and persist.
     */
    @PersistenceContext
    private EntityManager em;
    /**
     * employees assigned to the project.
     */
    List<Integer> yourEmps;
    /**
     * the current user.
     */
    @Inject
    private ManageUser emp;
    /**
     * the id of the currently selected project.
     */
    private int selectedproject;
    /**
     * retrieves all employees that have been assigned to the selected project.
     * @return a list containing employees assigned to a project.
     */
    public Wpassign getWpa(){
        return wpa;
    }
    public void setWpa(Wpassign w){
        wpa = w;
    }
    public List<Integer> getYourEmps(){
        if(yourEmps != null)
            yourEmps.clear();
        TypedQuery<Integer> q = em.createQuery("SELECT emp_ID FROM Availability "
                    + "WHERE proj_ID = :us", Integer.class);
                q.setParameter("us",selectedproject);
                yourEmps = (List<Integer>) q.getResultList();
        return yourEmps;
    }
    public void setYourEmps(List<Integer> y){
        yourEmps = y;
    }
    /**
     * retrieves all projects that the user is the manager of.
     * @return a list of project ids.
     */
    public List<Integer> getProjects(){
        TypedQuery<Integer> q = em.createQuery("SELECT proj_ID FROM Project "
                + "WHERE project_manager = :me", Integer.class);
            q.setParameter("me", emp.getEmp().getEmp_ID());
            return (List<Integer>) q.getResultList();
    }
    /**
     * retrieves all work packages within the selected project.
     * @return a list of work package ids.
     */
    public List<String> getWP(){
        TypedQuery<String> q = em.createQuery("SELECT wp_ID FROM WorkPackage "
                + "WHERE proj_ID = :me", String.class);
            q.setParameter("me", selectedproject);
            return (List<String>) q.getResultList();
    }
    /**
     * gets the selected project.
     * @return the chosen project.
     */
    public int getSelectedproject(){
        return selectedproject;
    }
    /**
     * sets the selected project.
     * @param n the new value for the selected project.
     */
    public void setSelectedproject(int n){
        wpa.setProj_ID(n);
        selectedproject = n;
    }
    /**
     * just persists the entity saving the data to the database.
     */
    public void assign(){
        em.persist(wpa);
    }
    public void handleProjChange(int id){
        selectedproject = id;
    }
}
