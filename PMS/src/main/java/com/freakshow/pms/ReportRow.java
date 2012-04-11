package com.freakshow.pms;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named("reportRow")
@SessionScoped
@Stateful
public class ReportRow {
    
    @PersistenceContext
    protected EntityManager em;
    private List<String> wp_ID;
    @Inject 
    ManageReport mr;
    private List<Long> actualHrs;
   
    public List<Long> getActualHrs() {
        try{
            TypedQuery<Long> q = em.createQuery("SELECT SUM(mon + tues + wed + thurs + fri) FROM TimeSheetRow WHERE proj_ID = :pj AND approved = :ap", Long.class); 
            q.setParameter("pj", mr.getProjID());  
            q.setParameter("ap", true);  
            actualHrs = q.getResultList();
        }
        catch(Exception ex){
            System.out.println("getTotalHrs" + ex);
        }               
        return actualHrs;
    }

    public void setActualHrs(List<Long> actualHrs) {
        this.actualHrs = actualHrs;
    }

    public ManageReport getMr() {
        return mr;
    }

    public void setMr(ManageReport mr) {
        this.mr = mr;
    }

    public List<String> getWp_ID() {
        try{
            TypedQuery<String> q = em.createQuery("SELECT wp_ID FROM WorkPackage WHERE proj_ID = :proj", String.class);
            q.setParameter("proj", mr.getProjID());
            wp_ID = q.getResultList();
        }
        catch(Exception ex){
            System.out.println("getReportRow failed\n" + ex);
        }            
        return wp_ID;
    }
    

    public void setWp_ID(List<String> wp_ID) {
        this.wp_ID = wp_ID;
    }
    
}
