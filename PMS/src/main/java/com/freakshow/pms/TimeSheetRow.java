package com.freakshow.pms;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="timesheetRow")
public class TimeSheetRow implements Serializable{
    
    @Id
	private int proj_ID;
	private String wp_ID;
	private int mon;
	private int fri;

	public TimeSheetRow(int proj_ID, String wp_ID, int mon, int fri){
        this.proj_ID = proj_ID;
        this.wp_ID = wp_ID;
        this.mon = mon;
        this.fri = fri;

	}

    public int getProj_ID() {
        return proj_ID;
    }

    public void setProj_ID(int proj_ID) {
        this.proj_ID = proj_ID;
    }

    public String getWp_ID() {
        return wp_ID;
    }

    public void setWp_ID(String wp_ID) {
        this.wp_ID = wp_ID;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getFri() {
        return fri;
    }

    public void setFri(int fri) {
        this.fri = fri;
    }
}
