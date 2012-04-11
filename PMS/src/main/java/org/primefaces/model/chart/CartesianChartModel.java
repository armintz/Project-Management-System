package org.primefaces.model.chart;  

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CartesianChartModel extends ChartModel implements Serializable {

    private List<ChartSeries> series = new ArrayList<ChartSeries>();

    public List<ChartSeries> getSeries() {
        return series;
    }

    public void addSeries(ChartSeries chartSeries) {
        this.series.add(chartSeries);
    }

    public void clear() {
        this.series.clear();
    }
    /**
     * Finds the categories using first series
     *
     * @return List of categories
     */
    public List<String> getCategories() {
        List<String> categories = new ArrayList<String>();
        
        if(series.size() > 0) {
            Map<Number, Number> firstSeriesData = series.get(0).getData();
            for(Iterator<Number> it = firstSeriesData.keySet().iterator(); it.hasNext();) {
                Object key = it.next();
                
                if(key instanceof String) {
                    categories.add(key.toString());
                } else {
                    break;
                }
            }
        }
        return categories;
    }    
}
