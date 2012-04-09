package com.freakshow.pms;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named("signTs")
@SessionScoped
@Stateful
public class SignTimesheet implements Serializable  {

    @PersistenceContext
    protected EntityManager em;
    
    @Inject
    public ManageUser emp;
    
    public List<TimeSheetRow> tsRow;
    public String cDate;
    public TimeSheet ts = new TimeSheet();
    
    public List<TimeSheetRow> getTsRow() {
        TypedQuery<TimeSheetRow> q = em.createQuery("SELECT t FROM TimeSheetRow t WHERE t.emp_ID = :eID AND t.signed = :sgn" , TimeSheetRow.class); 
        q.setParameter("eID", emp.getEmp().getEmp_ID());  
        q.setParameter("sgn", false);    
        tsRow = q.getResultList();
        return tsRow; 
    }

    public void setTsRow(List<TimeSheetRow> tsRow) {
        this.tsRow = tsRow;
    }


    public ManageUser getEmp() {
        return emp;
    }
    
    public void setEmp(ManageUser emp) {
        this.emp = emp;
    }
    
    public TimeSheet getTs() {
        return ts;
    }

    public void setTs(TimeSheet ts) {
        this.ts = ts;
    }

    public void signTs() {
        for (TimeSheetRow t : tsRow)
        {          
              t.setSigned(true);  
              em.merge(t);
              em.flush();
        } 
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Timesheet", "Signed!");           
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
}
