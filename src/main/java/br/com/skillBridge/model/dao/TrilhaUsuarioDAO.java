package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.TrilhaTO;
import br.com.skillBridge.model.dto.TrilhaUsuarioTO;
import oracle.jdbc.proxy.annotation.Pre;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class TrilhaUsuarioDAO {
    public ArrayList<TrilhaUsuarioTO> findAll(Long idUsuario) {
        ArrayList<TrilhaUsuarioTO> trilhaUsuarios = new ArrayList<>();

        String sql = "select * from t_skb_trilha_usuario tu inner join t_skb_trilha t " +
                "on (tu.id_trilha = t.id_trilha) where id_usuario=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    TrilhaUsuarioTO trilhaUsuario = new TrilhaUsuarioTO();
                    TrilhaTO trilha = new TrilhaTO();
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

    public TrilhaUsuarioTO save(Long idUsuario, TrilhaUsuarioTO trilhaUsuarioTO) {
        String sql = "insert into t_skb_trilha_usuario (nv_progresso, st_status, id_usuario, id_trilha, dt_criacao) " +
                "values (0, 'Iniciado', ?, ?, sysdate)";
        String[] colunasRetorno = {"id_trilha_usuario", "dt_criacao"};

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql, colunasRetorno)) {
            ps.setLong(1, idUsuario);
            ps.setLong(2, trilhaUsuarioTO.getTrilha().getId());

            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        trilhaUsuarioTO.setId(rs.getLong(1));
                        trilhaUsuarioTO.setDataCriacao(rs.getDate(2).toLocalDate());
                        trilhaUsuarioTO.setProgresso(0);
                        trilhaUsuarioTO.setStatus("Iniciado");
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro na criação: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return trilhaUsuarioTO;
    }
}
