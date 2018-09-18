package br.com.unipar.EstagioSerch.demo.rowmapper;

import br.com.unipar.EstagioSerch.demo.models.Empresa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.jdbc.core.RowMapper;

public class EmpresaRowMapper implements RowMapper<Empresa> {

    @Override
    public Empresa mapRow(ResultSet rs, int i) throws SQLException {

        Long cd_empresa = rs.getLong("cd_empresa");
        String nm_razao = rs.getString("nm_razao");
        String nm_fantasia = rs.getString("nm_fantasia");
        String nr_cnpj = rs.getString("nr_cnpj");
        String nm_representante = rs.getString("nm_representante");
        String st_universidade = rs.getString("st_universidade");
        Date dt_registro = rs.getDate("dt_registro");

        return new Empresa(cd_empresa, nm_razao, nm_fantasia, nr_cnpj, nm_representante, st_universidade, dt_registro);

    }

}
