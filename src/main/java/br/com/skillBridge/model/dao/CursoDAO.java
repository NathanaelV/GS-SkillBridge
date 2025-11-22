package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.CursoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoDAO {
    public CursoTO findByCode(Long codigo) {
        CursoTO curso = new CursoTO();
        String sql = "select * from t_skb_curso where id_curso=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                curso.setId(rs.getLong("id_curso"));
                curso.setNome(rs.getString("nm_curso"));
                curso.setNivel(rs.getString("nv_classificacao"));
                curso.setConteudoPrincipal(rs.getString("tx_conteudo_principal"));
                curso.setDataCriacao(rs.getDate("dt_criacao").toLocalDate());
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("\nErro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return curso;
    }
    
}
