package com.example.karim.shopandsave.model;

public class Report {

    private int id ;
    private String content ;
    private boolean state ;
    private int reportable_id ;
    private String reportable_type ;

    public Report(int id, String content, boolean state, int reportable_id, String reportable_type) {
        this.id = id;
        this.content = content;
        this.state = state;
        this.reportable_id = reportable_id;
        this.reportable_type = reportable_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getReportable_id() {
        return reportable_id;
    }

    public void setReportable_id(int reportable_id) {
        this.reportable_id = reportable_id;
    }

    public String getReportable_type() {
        return reportable_type;
    }

    public void setReportable_type(String reportable_type) {
        this.reportable_type = reportable_type;
    }
}
