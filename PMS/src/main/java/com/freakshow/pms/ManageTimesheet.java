package com.freakshow.pms;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
    public void saveTs(){
        
//        Date d = Calendar.getInstance().getTime();   
//        System.out.println("date: " + d);
//        ts.setWeek_end_day(d);
        ts.setEmp_ID(usr.getEmp().getEmp_ID());
        
        for (TimeSheetRow t : ts.getTsRows())
        {          
              t.setWeek_end_day(ts.getWeek_end_day());
              t.setEmp_ID(usr.getEmp().getEmp_ID());
        }
        
        em.persist(ts);        
//        TimeSheetRowPK pk = new TimeSheetRowPK();
//        pk.setWeek_end_day(date);
//        pk.setWp_ID("a1");
//        pk.setProj_ID(1);
//        pk.setEmp_ID(2);
//        TimeSheetRow ts = em.find(TimeSheetRow.class, pk);       
        
        
//        
    }
    
}