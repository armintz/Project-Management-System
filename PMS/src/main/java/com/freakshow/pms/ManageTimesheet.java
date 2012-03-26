package com.freakshow.pms;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * The Class ManageUser.
 */
@Named("manageTimesheet")
@SessionScoped
@Stateful
public class ManageTimesheet implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;   
    TimeSheetRow tsr = new TimeSheetRow();
    TimeSheet ts = new TimeSheet();
    
    @Inject
    Employee emp;
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
        
        //ts.setWeek_end_day(tsr.getWeek_end_day());
        ts.setEmp_ID(emp.getEmp_ID());
        
        em.persist(ts);        
//        TimeSheetRowPK pk = new TimeSheetRowPK();
//        pk.setWeek_end_day(date);
//        pk.setWp_ID("a1");
//        pk.setProj_ID(1);
//        pk.setEmp_ID(2);
//        TimeSheetRow ts = em.find(TimeSheetRow.class, pk);       
        
        
//        for (TimeSheetRow x : ts.getTsRows())
//        {
//            em.persist(x);
//        }
    }
    
}