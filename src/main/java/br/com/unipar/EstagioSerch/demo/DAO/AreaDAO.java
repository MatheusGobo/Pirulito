package br.com.unipar.EstagioSerch.demo.DAO;

import br.com.unipar.EstagioSerch.demo.models.Area;
import br.com.unipar.EstagioSerch.demo.rowmapper.AreaRowMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AreaDAO {

    @Autowired
    private JdbcTemplate template;
    // Teste GitHub
    public List<Area> lista(){
        
        String sql =
            "SELECT A.CD_AREA, A.DS_AREA\n"+
            "FROM AREA A";
        
        return template.query(sql, new AreaRowMapper());
    
    }
    
    public Area busca(Long cd_area){
        
        String sql =
            "SELECT A.CD_AREA, A.DS_AREA\n"+
            "FROM AREA A\n"+
            "WHERE A.CD_VAGA = ?";
        
        Object[] parametros = {cd_area};
    
        return template.queryForObject(sql, parametros, new AreaRowMapper());
        
    }
    
    
    public void salvar(Area area){
        
        String sql = 
            "INSERT INTO AREA(DS_AREA)\n"+
            "VALUES(?)";
        
        Object[] parametros = {area.getDs_area()};

        template.update(sql, parametros);
        
    } 
    
    public void atualizar(Long cd_area, Area area){
        
        String sql = 
            "UPDATE \n"+
            "FROM AREA SET\n"+
            "   DS_AREA = ?\n"+
            "WHERE CD_AREA = ?";
        
        Object[] parametros = {area.getDs_area(), cd_area};
        
        template.update(sql, parametros);
        
    }
    
    public void deletar(Long cd_area){
        
        String sql = 
            "DELETE \n"+
            "FROM AREA \n"+
            "WHERE CD_AREA = ?";
        
        Object[] parametros = {cd_area};
        
        template.update(sql, parametros);
    }
    
}
