package com.freakshow.pms;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SessionScoped
@Named("timeSheet")
@Entity
@Table(name="timesheet")
public class TimeSheet implements Serializable {
    
    @Id
    private int emp_ID;
    private Date week_end_day;
    private Boolean approved;
    
    @OneToMany(mappedBy = "ts")
    private Collection<TimeSheetRow> tsRows;
    
    public int getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }

    public Date getWeek_end_day() {
        return week_end_day;
    }

    public void setWeek_end_day(Date week_end_day) {
        this.week_end_day = week_end_day;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    
	private TimeSheetRow[] ts = {	        
        new TimeSheetRow(1,"a",3,4),
        new TimeSheetRow(2,"a",3,4),
        new TimeSheetRow(3,"a",3,4)
	};

    public TimeSheetRow[] getTs() {      
        return ts;
    }

    public void setTs(TimeSheetRow[] ts) {
        this.ts = ts;
    }

    public Collection<TimeSheetRow> getTsRows() {
        return tsRows;
    }

    public void setTsRows(Collection<TimeSheetRow> tsRows) {
        this.tsRows = tsRows;
    }
}

