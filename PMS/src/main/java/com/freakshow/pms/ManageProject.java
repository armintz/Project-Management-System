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
    String wpNo;
    Project proj = new Project();
    WorkPackage wp = new WorkPackage();
    Estimate est = new Estimate();
    List<Integer> availableProj;
    List<String> availableWP;
    List<String> reWP;    
    List<Integer> availablePM;
    private int curproj;
    public List<String> wpIDs;
    public List<Integer> projs;
    
    public int getProjNo() {
        return projNo;
    }

    public void setProjNo(int projNo) {
        this.projNo = projNo;
    }
    public String getWpNo() {
        return wpNo;
    }

    public void setWpNo(String wpNo) {
        this.wpNo = wpNo;
    }
    public int getCurproj() {
        return curproj;
    }

    public void setCurproj(int curproj) {
        this.curproj = curproj;
    }
    
    public List<String> getWpIDs() {
        return wpIDs;
    }

    public void setWpIDs(List<String> wpIDs) {
        this.wpIDs = wpIDs;
    }    
    
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
 
    public List<Integer> getProjs() {
        TypedQuery<Integer> q = em.createQuery("SELECT DISTINCT proj_ID FROM WorkPackage", Integer.class);
        List<Integer> rwp =  (List<Integer>)q.getResultList();        
        return rwp;
    }

    public void setProjs(List<Integer> projs) {
        this.projs = projs;
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
 

    public List<Integer> getAvailablePM() {     
        TypedQuery<Integer> q = em.createQuery("SELECT emp_ID FROM Employee WHERE role_PM = 1", Integer.class);
        List<Integer> emp =  (List<Integer>)q.getResultList();      
        return emp;
    }

    public void setAvailablePM(List<Integer> availablePM) {       
        this.availablePM = availablePM;
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
    
    public String editProj(int selectedProjID) {
        proj = em.find(Project.class, selectedProjID);
        return "edit_proj_details";
    }
    
    public void updateProj() {
        em.merge(proj);
        em.flush();
    } 

    public String editWP() {
        WorkPackagePK pk = new WorkPackagePK();
        pk.setProj_ID(projNo);
        pk.setWp_ID(wpNo);
        System.out.println( "WP #: " + wpNo);
        wp = em.find(WorkPackage.class, pk); 
        return "edit_wp_details";
      }
      
      public void updateWP() {
          em.merge(wp);
          em.flush();
      }
      
      public void handleWPChangeEdit(String selectedWPID) {  
          wpNo = selectedWPID;
      }    
     
    public void createWP() {
        em.persist(wp);      
    }
    
    public void handleChange(){      
        TypedQuery<String> w = em.createQuery("SELECT wp_ID FROM WorkPackage WHERE proj_ID = :proj", String.class); 
        w.setParameter("proj", projNo);
        wpIDs = w.getResultList();       
        if(wpIDs == null){
            System.out.println("error");
        }           
    }    
}