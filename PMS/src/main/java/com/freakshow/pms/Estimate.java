package com.freakshow.pms;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estimate")
public class Estimate {
    
    @Id
    private String wp_ID;
    private int proj_ID;
    private Date d;   
    private int md_p1;
    private int md_p2;
    private int md_p3;
    private int md_p4;
    private int md_p5;
    private int md_ds;
    private int md_ss;
    
    public String getWp_ID() {
        return wp_ID;
    }

    public void setWp_ID(String wp_ID) {
        this.wp_ID = wp_ID;
    }

    public int getProj_ID() {
        return proj_ID;
    }

    public void setProj_ID(int proj_ID) {
        this.proj_ID = proj_ID;
    }

    public Date getD() {
        return d;
    }

    public void setD(Date d) {
        this.d = d;
    }

    public int getMd_p1() {
        return md_p1;
    }

    public void setMd_p1(int md_p1) {
        this.md_p1 = md_p1;
    }

    public int getMd_p2() {
        return md_p2;
    }

    public void setMd_p2(int md_p2) {
        this.md_p2 = md_p2;
    }

    public int getMd_p3() {
        return md_p3;
    }

    public void setMd_p3(int md_p3) {
        this.md_p3 = md_p3;
    }

    public int getMd_p4() {
        return md_p4;
    }

    public void setMd_p4(int md_p4) {
        this.md_p4 = md_p4;
    }

    public int getMd_p5() {
        return md_p5;
    }

    public void setMd_p5(int md_p5) {
        this.md_p5 = md_p5;
    }

    public int getMd_ds() {
        return md_ds;
    }

    public void setMd_ds(int md_ds) {
        this.md_ds = md_ds;
    }

    public int getMd_ss() {
        return md_ss;
    }

    public void setMd_ss(int md_ss) {
        this.md_ss = md_ss;
    }
    
}
