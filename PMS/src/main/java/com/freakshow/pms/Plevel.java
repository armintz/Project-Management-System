package com.freakshow.pms;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="plevel")
public class Plevel {
    
    @Id
    private Date effective_date;   
    private int p1;
    private int p2;
    private int p3;
    private int p4;
    private int p5;
    private int ds;
    private int ss;
    
    public Date getEffective_date() {
        return effective_date;
    }
    public void setEffective_date(Date effective_date) {
        this.effective_date = effective_date;
    }
    public int getP1() {
        return p1;
    }
    public void setP1(int p1) {
        this.p1 = p1;
    }
    public int getP2() {
        return p2;
    }
    public void setP2(int p2) {
        this.p2 = p2;
    }
    public int getP3() {
        return p3;
    }
    public void setP3(int p3) {
        this.p3 = p3;
    }
    public int getP4() {
        return p4;
    }
    public void setP4(int p4) {
        this.p4 = p4;
    }
    public int getP5() {
        return p5;
    }
    public void setP5(int p5) {
        this.p5 = p5;
    }
    public int getDs() {
        return ds;
    }
    public void setDs(int ds) {
        this.ds = ds;
    }
    public int getSs() {
        return ss;
    }
    public void setSs(int ss) {
        this.ss = ss;
    }
    
    
}
