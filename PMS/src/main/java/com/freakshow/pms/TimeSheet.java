package com.freakshow.pms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
    
    @OneToMany
    private Collection<TimeSheetRow> tsRows= new ArrayList<TimeSheetRow>(Arrays.asList(
            new TimeSheetRow(),
            new TimeSheetRow(),
            new TimeSheetRow(),
            new TimeSheetRow()
            ));
    
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
    
	public String addRow(){
	    tsRows.add(new TimeSheetRow());
	    return "time_sheet";
	}

    public Collection<TimeSheetRow> getTsRows() {
        return tsRows;
    }

    public void setTsRows(Collection<TimeSheetRow> tsRows) {
        this.tsRows = tsRows;
    }
}

