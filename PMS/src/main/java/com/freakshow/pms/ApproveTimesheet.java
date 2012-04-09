package com.freakshow.pms;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

@Named("approveTs")
@SessionScoped
@Stateful
public class ApproveTimesheet implements Serializable  {

    @PersistenceContext
    protected EntityManager em;
    
    public Date chosenDate;
    public int chosenEmpID;
    
    @Inject
    public ManageUser emp;
    public List<Date> weekEndDates;
    public List<Integer> empIDs;      
    public List<TimeSheetRow> tsRow;
    public String cDate;
    
    public List<TimeSheetRow> getTsRow() {
        return tsRow;
    }

    public void setTsRow(List<TimeSheetRow> tsRow) {
        this.tsRow = tsRow;
    }

    public Date getChosenDate() {        
        return chosenDate;
    }
    
    public void setChosenDate(Date chosenDate) {
        this.chosenDate = chosenDate;
    }
    
    public String getCDate() {        
        return cDate;
    }   
    
    public void setCDate(String cDate) {
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.S");
        try {
            chosenDate = inputFormat.parse(cDate);
        } catch (ParseException e) {
            System.out.println("error parsing date" + e);
            e.printStackTrace();
        }       
    }    
    
    public int getChosenEmpID() {
        return chosenEmpID;
    }
    
    public void setChosenEmpID(int chosenEmpID) {
        this.chosenEmpID = chosenEmpID;
    }
    
    public ManageUser getEmp() {
        return emp;
    }
    
    public void setEmp(ManageUser emp) {
        this.emp = emp;
    }
    
    public List<Date> getWeekEndDates() {
        try{
            TypedQuery<Date> q = em.createQuery("SELECT DISTINCT week_end_day FROM TimeSheet", Date.class);
            weekEndDates =  q.getResultList();             
        }
        catch(Exception ex)
        {
            System.out.println("Error in fetching week end dates" + ex);
        }
         
        return weekEndDates;
    }
    
    public void setWeekEndDates(List<Date> weekEndDates) {
        this.weekEndDates = weekEndDates;
    }
    
    public List<Integer> getEmpIDs() {
        try{
            TypedQuery<Integer> q = em.createQuery("SELECT emp_ID FROM TimeSheet", Integer.class);
            empIDs =  q.getResultList();             
        }
        catch(Exception ex)
        {
            System.out.println("Error in fetching week end dates" + ex);
        }                            
        return empIDs;
    }
    
    public void setEmpIDs(List<Integer> empIDs) {
        this.empIDs = empIDs;
    }
    
    public void handleDateChange(Date d){
        chosenDate = d;
    }
    
    public boolean showPanelApprove(){
        TypedQuery<Integer> q = em.createQuery("SELECT emp_ID FROM Employee WHERE ts_approver_ID = :apr", Integer.class); 
        q.setParameter("apr", emp.getEmp().getEmp_ID());        
        if (q.getResultList() != null)
            return true;
        else
            return false;
    }
     
    public String approveTS(){
        TypedQuery<TimeSheetRow> q = em.createQuery("SELECT t FROM TimeSheetRow t WHERE t.week_end_day = :wEnd AND t.emp_ID = :empID And signed = :sgnd", TimeSheetRow.class); 
        q.setParameter("wEnd", chosenDate, TemporalType.DATE);
        q.setParameter("empID", chosenEmpID);  
        q.setParameter("sgnd", true);  
        tsRow = q.getResultList();   
        return "timesheet_approve";   
    }
    public void apprTs(){
        
        for (TimeSheetRow t : tsRow)
        {          
              t.setApproved(true);  
              em.merge(t);
              em.flush();
        } 
    }
}
