package org.primefaces.model.chart; 

public class LineChartSeries extends ChartSeries {

    private String markerStyle = "filledCircle";

    private boolean showLine = true;

    public LineChartSeries() {
    }

    public LineChartSeries(String title) {
        super(title);
    }

    public String getMarkerStyle() {
        return markerStyle;
    }

    public void setMarkerStyle(String markerStyle) {
        this.markerStyle = markerStyle;
    }

    public boolean isShowLine() {
        return showLine;
    }

    public void setShowLine(boolean showLine) {
        this.showLine = showLine;
    }
}