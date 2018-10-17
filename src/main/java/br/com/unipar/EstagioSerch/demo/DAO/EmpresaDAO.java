package br.com.unipar.EstagioSerch.demo.DAO;

import br.com.unipar.EstagioSerch.demo.rowmapper.EmpresaRowMapper;
import br.com.unipar.EstagioSerch.demo.models.Empresa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmpresaDAO {

    @Autowired
    private JdbcTemplate template;

    public List<Empresa> lista() {

        String sql =
                "SELECT E.CD_EMPRESA, E.NM_RAZAO, E.NM_FANTASIA, E.NR_CNPJ, E.NM_REPRESENTANTE, E.ST_UNIVERSIDADE, E.DT_REGISTRO\n" +
                        "FROM EMPRESA E";

        return template.query(sql, new EmpresaRowMapper());

    }

    public Empresa busca(Long cd_empresa) {

        String sql =
                "SELECT E.CD_EMPRESA, E.NM_RAZAO, E.NM_FANTASIA, E.NR_CNPJ, E.NM_REPRESENTANTE, E.ST_UNIVERSIDADE, E.DT_REGISTRO\n " +
                        "FROM EMPRESA E\n " +
                        "WHERE E.CD_EMPRESA = ?";

        Object[] parametros = {cd_empresa};

        return template.queryForObject(sql, parametros, new EmpresaRowMapper());

    }

    public void salvar(Empresa empresa) {

        String sql =
                "INSERT INTO EMPRESA (NM_RAZAO, NM_FANTASIA, NR_CNPJ,\n" +
                        "NM_REPRESENTANTE, ST_UNIVERSIDADE)\n" +
                        "VALUES(?, ?, ?, ?, ?)";
        Object[] parametros =
                {empresa.getNm_razao(), empresa.getNm_fantasia(), empresa.getNr_cnpj(),
                        empresa.getNm_representante(), empresa.getSt_universidade()};

        template.update(sql, parametros);

    }

    public void atualizar(Long cd_empresa, Empresa empresa) {
        String sql =
                "UPDATE FROM EMPRESA SET\n" +
                        "	NM_RAZAO = ?, \n" +
                        "	NM_FANTASIA = ?, \n" +
                        "	NR_CNPJ = ?, \n" +
                        "	NM_REPRESENTANTE = ?, \n" +
                        "	ST_UNIVERSIDADE = ?\n" +
                        "WHERE CD_EMPRESA = ?";

        Object[] parametros =
                {empresa.getNm_razao(), empresa.getNm_fantasia(),
                        empresa.getNr_cnpj(), empresa.getNm_representante(),
                        empresa.getSt_universidade(), cd_empresa};

        template.update(sql, parametros);

    }

    public void deletar(Long cd_empresa) {

        String sql =
                "DELETE \n" +
                        "FROM EMPRESA \n" +
                        "WHERE CD_EMPRESA = ?";

        Object[] parametros = {cd_empresa};

        template.update(sql, parametros);

    }

}
