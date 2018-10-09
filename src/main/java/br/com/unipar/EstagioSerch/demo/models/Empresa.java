package br.com.unipar.EstagioSerch.demo.models;

import java.util.Date;

public class Empresa {
    
    private Long cd_empresa;
    private String nm_razao;
    private String nm_fantasia;
    private String nr_cnpj;
    private String nm_representante;
    private String st_universidade;
    private Date dt_registro;

    public Empresa(){}
    
    public Empresa(Long cd_empresa, String nm_razao, String nm_fantasia, String nr_cnpj, String nm_representante, String st_universidade, Date dt_registro) {
        this.cd_empresa = cd_empresa;
        this.nm_razao = nm_razao;
        this.nm_fantasia = nm_fantasia;
        this.nr_cnpj = nr_cnpj;
        this.nm_representante = nm_representante;
        this.st_universidade = st_universidade;
        this.dt_registro = dt_registro;
    }

    public Long getCd_empresa() {
        return cd_empresa;
    }

    public void setCd_empresa(Long cd_empresa) {
        this.cd_empresa = cd_empresa;
    }

    public String getNm_razao() {
        return nm_razao;
    }

    public void setNm_razao(String nm_razao) {
        this.nm_razao = nm_razao;
    }

    public String getNm_fantasia() {
        return nm_fantasia;
    }

    public void setNm_fantasia(String nm_fantasia) {
        this.nm_fantasia = nm_fantasia;
    }

    public String getNr_cnpj() {
        return nr_cnpj;
    }

    public void setNr_cnpj(String nr_cnpj) {
        this.nr_cnpj = nr_cnpj;
    }

    public String getNm_representante() {
        return nm_representante;
    }

    public void setNm_representante(String nm_representante) {
        this.nm_representante = nm_representante;
    }

    public String getSt_universidade() {
        return st_universidade;
    }

    public void setSt_universidade(String st_universidade) {
        this.st_universidade = st_universidade;
    }

    public Date getDt_registro() {
        return dt_registro;
    }

    public void setDt_registro(Date dt_registro) {
        this.dt_registro = dt_registro;
    }
    
    
}
