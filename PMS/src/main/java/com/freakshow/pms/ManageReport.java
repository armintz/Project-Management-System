package com.freakshow.pms;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartSeries;

@Named("manageReport")
@SessionScoped
@Stateful
public class ManageReport implements Serializable {
    
    @PersistenceContext
    protected EntityManager em;
    private int projID;
    private String projName;
    private int projectManager;

    private CartesianChartModel linearModel;  
    private CartesianChartModel categoryModel;  

    private int actualHrs = 0;

    public ManageReport() {  
        createLinearModel();  
        createCategoryModel();     
    }  
    
    
    public int getProjID() {
        return projID;
    }

    public void setProjID(int projID) {
        this.projID = projID;
    }  
    
    public CartesianChartModel getLinearModel() {  
        return linearModel;  
    }  
    
    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CartesianChartModel categoryModel) {
        this.categoryModel = categoryModel;
    }
    
    public int getActualHrs() {
        return actualHrs;
    }

    public void setActualHrs(int actualHrs) {
        this.actualHrs = actualHrs;
    }  
    
    public String getProjName() {
        try{
            TypedQuery<String> q = em.createQuery("SELECT proj_name FROM Project WHERE proj_ID = :pj", String.class);
            q.setParameter("pj", projID);
            projName =  q.getSingleResult();
        }
        catch(Exception ex){
            System.out.println("getReWP" + ex);
        }       
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public int getProjectManager() {
        try{
            TypedQuery<Integer> q = em.createQuery("SELECT project_manager FROM Project WHERE proj_ID = :pj", Integer.class);
            q.setParameter("pj", projID);
            projectManager =  q.getSingleResult();
        }
        catch(Exception ex){
            System.out.println("getReWP" + ex);
        }                      
        return projectManager;
    }

    public void setProjectManager(int projectManager) {
        this.projectManager = projectManager;
    }    
    
    public String viewReport(){
        return "report_view_detail";
    }
    
    private void createLinearModel() {  
        linearModel = new CartesianChartModel();  
  
        LineChartSeries series1 = new LineChartSeries();  
        series1.setLabel("Actual");  
  
        series1.set(1, 2);  
        series1.set(2, 1);  
        series1.set(3, 3);  
        series1.set(4, 6);  
        series1.set(5, 8);  
  
        LineChartSeries series2 = new LineChartSeries();  
        series2.setLabel("Estimate");  
        series2.setMarkerStyle("diamond");  
  
        series2.set(1, 6);  
        series2.set(2, 3);  
        series2.set(3, 2);  
        series2.set(4, 7);  
        series2.set(5, 9);  
  
        linearModel.addSeries(series1);  
        linearModel.addSeries(series2);  
    } 
    
    private void createCategoryModel() {  

        categoryModel = new CartesianChartModel();  
        
        ChartSeries actual = new ChartSeries();  
        actual.setLabel("Actual");  
        actual.set(1, 125);  
        actual.set(2, 100);  
        actual.set(3, 44);  
        actual.set(4, 150);  
        actual.set(5, 25);  
  
        ChartSeries estimated = new ChartSeries();  
        estimated.setLabel("Estimated");  
  
        estimated.set(1, 52);  
        estimated.set(2, 60);  
        estimated.set(3, 110);  
        estimated.set(4, 135);  
        estimated.set(5, 120);  
  
        categoryModel.addSeries(actual);  
        categoryModel.addSeries(estimated);  
    }
   
}