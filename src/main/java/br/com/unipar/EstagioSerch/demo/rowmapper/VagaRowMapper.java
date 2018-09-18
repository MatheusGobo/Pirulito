package br.com.unipar.EstagioSerch.demo.rowmapper;

import br.com.unipar.EstagioSerch.demo.models.Vaga;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class VagaRowMapper implements RowMapper<Vaga> {

    @Override
    public Vaga mapRow(ResultSet rs, int i) throws SQLException {

        Long cd_vaga = rs.getLong("cd_vaga");
        Long cd_area = rs.getLong("cd_area");
        String ds_vaga = rs.getString("ds_vaga");
        String ds_requisitos = rs.getString("ds_requisitos");
        String ds_titulo = rs.getString("ds_titulo");
        
        return new Vaga(cd_vaga, cd_area, ds_vaga, ds_requisitos, ds_titulo);

    }

}
