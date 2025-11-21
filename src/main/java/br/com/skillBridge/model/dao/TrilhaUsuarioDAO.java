package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.TrilhaTO;
import br.com.skillBridge.model.dto.TrilhaUsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrilhaUsuarioDAO {
    public ArrayList<TrilhaUsuarioTO> findAll(Long idUsuario) {
        ArrayList<TrilhaUsuarioTO> trilhaUsuarios = new ArrayList<>();
        TrilhaTO trilha = new TrilhaTO();

        String sql = "select * from t_skb_trilha_usuario tu inner join t_skb_trilha t " +
                "on (tu.id_trilha = t.id_trilha) where id_usuario=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    TrilhaUsuarioTO trilhaUsuario = new TrilhaUsuarioTO();
                    trilhaUsuario.setId(rs.getLong("id_trilha_usuario"));
                    trilhaUsuario.setProgresso(rs.getInt("nv_progresso"));
                    trilhaUsuario.setStatus(rs.getString("st_status"));
                    trilhaUsuario.setDataCriacao(rs.getDate("dt_criacao").toLocalDate());
                    trilha.setId(rs.getLong("id_trilha"));
                    trilha.setNome(rs.getString("nm_trilha"));
                    trilha.setDescricao(rs.getString("nm_descricao"));
                    trilha.setAreaProfissional(rs.getString("nm_area_profissional"));
                    trilhaUsuario.setTrilha(trilha);
                    trilhaUsuarios.add(trilhaUsuario);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return trilhaUsuarios;
    }


}
