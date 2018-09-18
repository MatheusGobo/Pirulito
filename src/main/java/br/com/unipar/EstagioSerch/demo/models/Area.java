package br.com.unipar.EstagioSerch.demo.models;

import java.util.Date;

public class Area {
    
    private Long cd_area;
    private String ds_area;
    private Date dt_registro;

    public Area(){}
    
    public Area(Long cd_area, String ds_area) {
        this.cd_area = cd_area;
        this.ds_area = ds_area;
    }    
    
    public Long getCd_area() {
        return cd_area;
    }

    public void setCd_area(Long cd_area) {
        this.cd_area = cd_area;
    }

    public String getDs_area() {
        return ds_area;
    }

    public void setDs_area(String ds_area) {
        this.ds_area = ds_area;
    }

    public Date getDt_registro() {
        return dt_registro;
    }

    public void setDt_registro(Date dt_registro) {
        this.dt_registro = dt_registro;
    }
    
    
}
