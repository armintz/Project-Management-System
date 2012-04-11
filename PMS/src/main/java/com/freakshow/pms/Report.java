package com.freakshow.pms;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="report")
public class Report {
    
    @Id
    private int report_ID;
    private Date report_Date;

    
    
    public int getReport_ID() {
        return report_ID;
    }
    public void setReport_ID(int report_ID) {
        this.report_ID = report_ID;
    }
    public Date getReport_Date() {
        return report_Date;
    }
    public void setReport_Date(Date report_Date) {
        this.report_Date = report_Date;
    }

}
