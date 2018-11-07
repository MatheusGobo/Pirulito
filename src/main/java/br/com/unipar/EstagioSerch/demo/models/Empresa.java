package br.com.unipar.EstagioSerch.demo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Empresa")
@SequenceGenerator(name = "empresa", sequenceName = "empresa_id_seq", allocationSize = 1)
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "empresa")
    @Column(name = "cd_empresa")
    private Long cd_empresa;

    @Column(name = "nm_razao", length = 128, nullable = false)
    private String nm_razao;

    @Column(name = "nm_fantasia", length = 128)
    private String nm_fantasia;

    @Column(name = "nr_cnpj", length = 32)
    private String nr_cnpj;

    @Column(name = "nm_representante", length = 128,nullable = false)
    private String nm_representante;

    @Enumerated(EnumType.STRING)
    @Column(name = "tp_categoriaEmpresa", length = 32, nullable = false)
    private CategoriaEmpresa categoriaEmpresa;

    @Column(name = "dt_registro", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Date dt_registro;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
    private List<Vaga> vagas;

    public Empresa() {
    }

    public Empresa(Long cd_empresa, String nm_razao, String nm_fantasia, String nr_cnpj, String nm_representante, CategoriaEmpresa categoriaEmpresa, Date dt_registro) {
        this.cd_empresa = cd_empresa;
        this.nm_razao = nm_razao;
        this.nm_fantasia = nm_fantasia;
        this.nr_cnpj = nr_cnpj;
        this.nm_representante = nm_representante;
        this.categoriaEmpresa = categoriaEmpresa;
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

    public CategoriaEmpresa getCategoriaEmpresa() {
        return categoriaEmpresa;
    }

    public void setCategoriaEmpresa(CategoriaEmpresa categoriaEmpresa) {
        this.categoriaEmpresa = categoriaEmpresa;
    }

    public Date getDt_registro() {
        return dt_registro;
    }

    public void setDt_registro(Date dt_registro) {
        this.dt_registro = dt_registro;
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }
}
