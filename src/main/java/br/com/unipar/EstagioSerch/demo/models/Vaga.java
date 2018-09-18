package br.com.unipar.EstagioSerch.demo.models;

import java.util.Date;

public class Vaga {
    
    private Long cd_vaga;
    private Long cd_area;
    private Empresa empresa;
    private String ds_vaga;
    private String ds_requisitos;
    private String ds_titulo;
    private Date dt_registro;

    public Vaga(){}

    public Vaga(Long cd_vaga, Long cd_area, String ds_vaga, String ds_requisitos, String ds_titulo) {
        this.cd_vaga = cd_vaga;
        this.cd_area = cd_area;
        this.ds_vaga = ds_vaga;
        this.ds_requisitos = ds_requisitos;
        this.ds_titulo = ds_titulo;
    }

    public String getDs_titulo() {
        return ds_titulo;
    }

    public void setDs_titulo(String ds_titulo) {
        this.ds_titulo = ds_titulo;
    }
    
    
    public Long getCd_vaga() {
        return cd_vaga;
    }

    public void setCd_vaga(Long cd_vaga) {
        this.cd_vaga = cd_vaga;
    }

    public Long getCd_area() {
        return cd_area;
    }

    public void setCd_area(Long cd_area) {
        this.cd_area = cd_area;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getDs_vaga() {
        return ds_vaga;
    }

    public void setDs_vaga(String ds_vaga) {
        this.ds_vaga = ds_vaga;
    }

    public String getDs_requisitos() {
        return ds_requisitos;
    }

    public void setDs_requisitos(String ds_requisitos) {
        this.ds_requisitos = ds_requisitos;
    }

    public Date getDt_registro() {
        return dt_registro;
    }

    public void setDt_registro(Date dt_registro) {
        this.dt_registro = dt_registro;
    }
    
        
}
