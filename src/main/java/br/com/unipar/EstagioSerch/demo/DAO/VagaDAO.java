package br.com.unipar.EstagioSerch.demo.DAO;

import br.com.unipar.EstagioSerch.demo.models.Vaga;
import br.com.unipar.EstagioSerch.demo.rowmapper.VagaRowMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class VagaDAO {
    
    @Autowired
    private JdbcTemplate template;
    
    public List<Vaga> lista(){

        String sql = 
            "SELECT V.CD_EMPRESA, V.CD_VAGA, V.CD_AREA, V.DS_VAGA, V.DS_REQUISITOS, V.DS_TITULO\n" +
            "FROM VAGA V";

        return template.query(sql, new VagaRowMapper());

    }
    
    public Vaga busca(Long cd_vaga){

        String sql = 
            "SELECT V.CD_VAGA, V.CD_AREA, V.DS_VAGA, V.DS_REQUISITOS, V.DS_TITULO\n" +
            "FROM VAGA V \n"+
            "WHERE V.CD_VAGA = ?";

        Object[] parametros = {cd_vaga};
        
        return template.queryForObject(sql, parametros, new VagaRowMapper());
        
    }
    
    public void salvar(Vaga vaga){
        
        String sql = 
            "INSERT INTO VAGA (CD_AREA,CD_EMPRESA, DS_VAGA, DS_REQUISITOS, DS_TITULO)\n" +
            "VALUES(?, ? , ?, ?, ?)";
        
        Object[] parametros = 
            {vaga.getCd_area(),vaga.getCd_empresa(), vaga.getDs_vaga(),
             vaga.getDs_requisitos(), vaga.getDs_titulo()};
        
        template.update(sql, parametros);
    }
    
    public void atualizar(Long cd_vaga, Vaga vaga){
        
        String sql =
            "UPDATE FROM VAGA SET\n" +
            "	CD_AREA = ?, \n"+
            "	DS_VAGA = ?, \n"+
            "	DS_REQUISITOS = ?, \n"+
            "   DS_TITULO = ? \n"+
            "WHERE CD_VAGA = ?";
        
        Object[] parametros =
            {vaga.getCd_area(), vaga.getDs_vaga(), vaga.getDs_requisitos(), cd_vaga};
        
        template.update(sql, parametros);
        
    }
    
    public void deletar(Long cd_vaga){
        
        String sql = 
            "DELETE\n"+
            "FROM VAGA\n"+
            "WHERE CD_VAGA = ?";
        
        Object[] parametros = {cd_vaga};
        
        template.update(sql, parametros);
        
    }
}
