package com.freakshow.pms;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named("manageStatus")
@SessionScoped
@Stateful
public class ManageStatus implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;
    @Inject 
    ManageUser emp;   
    List<String> reWP;    
    private String wpID;
    private String wpName;
    private Date statusDate;
    private int curproj;
    private List<String> wpIDs;
    public List<Integer> projs;
    private int pmID;
    private int weekNum;
    private long totalHrs;
    private String comments;
    private String workAccomplished;
    private String workPlanned;
    private String problemsAnticipated;
    private String problemPeriod;
    
    public int getWeekNum() {
        GregorianCalendar calendar = new GregorianCalendar();
        weekNum = calendar.get(Calendar.WEEK_OF_YEAR);
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }
    
    public int getPmID() {
        try{
            TypedQuery<Integer> w = em.createQuery("SELECT project_manager FROM Project WHERE proj_ID = :pj", Integer.class); 
            w.setParameter("pj", curproj);  
            pmID = w.getSingleResult();       
        }
        catch(Exception ex){
            System.out.println("getPmID" + ex);
        }
        return pmID;
    }

    public void setPmID(int pmID) {
        this.pmID = pmID;
    }

    public List<String> getWpIDs() {
        return wpIDs;
    }

    public void setWpIDs(List<String> wpIDs) {
        this.wpIDs = wpIDs;
    }

    public int getCurproj() {
        return curproj;
    }

    public void setCurproj(int curproj) {
        this.curproj = curproj;
    }

    public Date getStatusDate() {
        Date d = Calendar.getInstance().getTime();   
        statusDate = d;          
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    public String getWpID() {
        return wpID;
    }

    public void setWpID(String wpID) {
        this.wpID = wpID;
    }

    public ManageUser getEmp() {
        return emp;
    }

    public void setEmp(ManageUser emp) {
        this.emp = emp;
    }   
 
    public long getTotalHrs() {
        try{
            TypedQuery<Long> q = em.createQuery("SELECT SUM(mon + tues + wed + thurs + fri) FROM TimeSheetRow WHERE proj_ID = :pj AND wp_ID = :wp AND approved = :ap", Long.class); 
            q.setParameter("pj", curproj);  
            q.setParameter("wp", wpID);         
            q.setParameter("ap", true);  
            totalHrs = q.getSingleResult();   
        }
        catch(Exception ex){
            System.out.println("getTotalHrs" + ex);
        }        
        return totalHrs;
    }

    public void setTotalHrs(long totalHrs) {
        this.totalHrs = totalHrs;
    }
    
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getWorkAccomplished() {
        return workAccomplished;
    }

    public void setWorkAccomplished(String workAccomplished) {
        this.workAccomplished = workAccomplished;
    }

    public String getWorkPlanned() {
        return workPlanned;
    }

    public void setWorkPlanned(String workPlanned) {
        this.workPlanned = workPlanned;
    }

    public String getProblemsAnticipated() {
        return problemsAnticipated;
    }

    public void setProblemsAnticipated(String problemsAnticipated) {
        this.problemsAnticipated = problemsAnticipated;
    }

    public String getWpName() {
        try{
            TypedQuery<String> q = em.createQuery("SELECT Description FROM WorkPackage WHERE wp_ID = :wp AND proj_ID = :prj", String.class); 
            q.setParameter("wp", wpID);  
            q.setParameter("prj", curproj);  
            wpName = q.getSingleResult();    
        }
        catch(Exception ex){
            System.out.println("getWpName" + ex);
        }       
        return wpName;
    }

    public void setWpName(String wpName) {
        this.wpName = wpName;
    }   
    
    public List<String> getReWP() {
        List<String> rwp = null;  
        try{
            TypedQuery<String> q = em.createQuery("SELECT wp_ID FROM WorkPackage WHERE responsible_engineer = :re", String.class);
            q.setParameter("re", emp.getEmp().getEmp_ID());
            rwp =  (List<String>)q.getResultList(); 
        }
        catch(Exception ex){
            System.out.println("getReWP" + ex);
        }
        return rwp;
    }

    public void setReWP(List<String> reWP) {
        this.reWP = reWP;
    }  
    
    public List<Integer> getProjs() {
        List<Integer> rwp = null;
        try{
            TypedQuery<Integer> q = em.createQuery("SELECT DISTINCT proj_ID FROM WorkPackage WHERE responsible_engineer = :re", Integer.class);
            q.setParameter("re", emp.getEmp().getEmp_ID());
            rwp =  (List<Integer>)q.getResultList();    
        }
        catch(Exception ex){
            System.out.println("getProjs" + ex);
        }        
        return rwp;
    }

    public void setProjs(List<Integer> projs) {
        this.projs = projs;
    }     
    
    public String createReport(){
        return "report_create_detail";
    }
    
    public void handleChange(){
        try{
            TypedQuery<String> w = em.createQuery("SELECT wp_ID FROM WorkPackage WHERE proj_ID = :proj AND responsible_engineer = :re", String.class); 
            w.setParameter("re", emp.getEmp().getEmp_ID());       
            w.setParameter("proj", curproj);
            wpIDs = w.getResultList();     
        }
        catch(Exception ex){
            System.out.println("handChange error: " + ex);
        }  
        if(wpIDs == null){
            System.out.println("error");
        }           
    }

    public String getProblemPeriod() {
        return problemPeriod;
    }

    public void setProblemPeriod(String problemPeriod) {
        this.problemPeriod = problemPeriod;
    }
}