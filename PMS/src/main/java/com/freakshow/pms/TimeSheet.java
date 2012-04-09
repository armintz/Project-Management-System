package com.freakshow.pms;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="timesheet")
@IdClass(TimeSheetPK.class)
public class TimeSheet implements Serializable {
    
    @Id 
    private int emp_ID;
    @Id
    private Date week_end_day;
    
    @OneToMany(cascade = CascadeType.ALL)
    public Collection<TimeSheetRow> tsRows;
        
    public TimeSheet(){ 
        tsRows = new ArrayList<TimeSheetRow>(Arrays.asList(
                new TimeSheetRow()
                ));
    }
   
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

    public Collection<TimeSheetRow> getTsRows() {          
        return tsRows;
    }

    public void setTsRows(Collection<TimeSheetRow> tsRows) {       
        this.tsRows = tsRows;
    }
}

