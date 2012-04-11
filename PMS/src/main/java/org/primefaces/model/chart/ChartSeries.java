package org.primefaces.model.chart;  

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class ChartSeries implements Serializable {

    private String title;

    private Map<Number,Number> data = new LinkedHashMap<Number, Number>();

    public ChartSeries() {}

    public ChartSeries(String title) {
        this.title = title;
    }

    public ChartSeries(String title, Map<Number, Number> data) {
        this.title = title;
        this.data = data;
    }

    public String getLabel() {
        return title;
    }

    public void setLabel(String title) {
        this.title = title;
    }
    
    public Map<Number, Number> getData() {
        return data;
    }

    public void setData(Map<Number, Number> data) {
        this.data = data;
    }

    public void set(Number x, Number y) {
        this.data.put(x, y);
    }    
}
