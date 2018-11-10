package br.com.unipar.EstagioSerch.demo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vaga")
@SequenceGenerator(name = "vaga", sequenceName = "vaga_id_seq", allocationSize = 1)
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vaga")
    @Column(name = "cd_vaga")
    private Long cd_vaga;

    @ManyToOne
    private Area area;

    @ManyToOne
    private Empresa empresa;

    @Column(name = "ds_vaga", length = 5000, nullable = false)
    private String ds_vaga;

    @Column(name = "ds_requisitos", length = 128, nullable = false)
    private String ds_requisitos;

    @Column(name = "ds_titulo", length = 128, nullable = false)
    private String ds_titulo;

    @GeneratedValue
    @Column(name = "dt_registro", columnDefinition = "date DEFAULT CURRENT_DATE", nullable = false)
    private Date dt_registro;

    public Vaga() {
    }

    public Vaga(Long cd_vaga, String ds_vaga, String ds_requisitos, String ds_titulo) {
        this.ds_vaga = ds_vaga;
        this.ds_requisitos = ds_requisitos;
        this.ds_titulo = ds_titulo;
        this.cd_vaga = cd_vaga;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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