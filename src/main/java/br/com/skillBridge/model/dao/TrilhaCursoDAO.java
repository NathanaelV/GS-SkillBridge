package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.CursoTO;
import br.com.skillBridge.model.dto.TrilhaCursoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrilhaCursoDAO {
    public ArrayList<CursoTO> findAll(Long idTrilha) {
        ArrayList<CursoTO> cursos = new ArrayList<>();

        String sql = "select c.id_curso, c.nm_curso, c.nv_classificacao, c.dt_criacao\n" +
                "    from t_skb_trilha_curso tc inner join t_skb_curso c\n" +
                "    on (tc.id_curso = c.id_curso)\n" +
                "    where id_trilha=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, idTrilha);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                while (rs.next()) {
                    CursoTO curso = new CursoTO();
                    curso.setId(rs.getLong("id_curso"));
                    curso.setNome(rs.getString("nm_curso"));
                    curso.setNivel(rs.getString("nv_classificacao"));
                    curso.setDataCriacao(rs.getDate("dt_criacao").toLocalDate());
                    cursos.add(curso);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return cursos;
    }

}
