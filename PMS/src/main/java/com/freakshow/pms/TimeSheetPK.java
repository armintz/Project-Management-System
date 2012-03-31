package com.freakshow.pms;

import java.io.Serializable;
import java.util.Date;

public class TimeSheetPK implements Serializable {
    
    private Date week_end_day;
    private int emp_ID;

    public Date getWeek_end_day() {
        return week_end_day;
    }

    public void setWeek_end_day(Date week_end_day) {    
        this.week_end_day = week_end_day;
    }

    public int getEmp_ID() {
        return emp_ID;
    }

    public void setEmp_ID(int emp_ID) {
        this.emp_ID = emp_ID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + emp_ID;
        result = prime * result
                + ((week_end_day == null) ? 0 : week_end_day.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TimeSheetPK other = (TimeSheetPK) obj;
        if (emp_ID != other.emp_ID)
            return false;
        if (week_end_day == null) {
            if (other.week_end_day != null)
                return false;
        } else if (!week_end_day.equals(other.week_end_day))
            return false;
        return true;
    }
}
