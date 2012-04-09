package com.freakshow.pms;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Named("manageTimesheet")
@SessionScoped
@Stateful
public class ManageTimesheet implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;  
    
    TimeSheetRow tsr = new TimeSheetRow();
    TimeSheet ts = new TimeSheet();

    @Inject
    ManageUser usr;
    
    public ManageUser getUsr() {
        return usr;
    }

    public void setUsr(ManageUser usr) {
        this.usr = usr;
    }

    public TimeSheetRow getTsr() {
        return tsr;
    }

    public void setTsr(TimeSheetRow tsr) {
        this.tsr = tsr;
    }

    public TimeSheet getTs() {
        return ts;
    }

    public void setTs(TimeSheet ts) {
        this.ts = ts;
    }
    
    public String addRow(){
        ts.tsRows.add(new TimeSheetRow());
        return "time_sheet";
    }
    
    public String removeRow(TimeSheetRow tempTs){
        ts.tsRows.remove(tempTs);

        return "time_sheet";
    }
    
    public void saveTs(){      
        //loadEx();
        ts.setEmp_ID(usr.getEmp().getEmp_ID());

        for (TimeSheetRow t : ts.getTsRows())
        {          
              t.setWeek_end_day(ts.getWeek_end_day());
              t.setEmp_ID(usr.getEmp().getEmp_ID());
              t.setApproved(false);
              t.setSigned(false);
        }      
        em.merge(ts);    
        em.flush();
//        TimeSheetRowPK pk = new TimeSheetRowPK();
//        pk.setWeek_end_day(date);
//        pk.setWp_ID("a1");
//        pk.setProj_ID(1);
//        pk.setEmp_ID(2);
//        TimeSheetRow ts = em.find(TimeSheetRow.class, pk);           
    }    
    
    public String loadEx(){
        TypedQuery<TimeSheetRow> q = em.createQuery("SELECT t FROM TimeSheetRow t WHERE emp_ID = :eID AND signed = :sgn" , TimeSheetRow.class); 
        q.setParameter("eID", usr.getEmp().getEmp_ID());  
        q.setParameter("sgn", false);          
        for(TimeSheetRow t: q.getResultList()){
            ts.tsRows.add(t);
        }
        return "time_sheet";
    }
}