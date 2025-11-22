package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.TrilhaTO;
import br.com.skillBridge.model.dto.TrilhaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TrilhaDAO {
    public ArrayList<TrilhaTO> findAll() {
        ArrayList<TrilhaTO> trilhas = new ArrayList<TrilhaTO>();

        String sql = "select * from t_skb_trilha order by id_trilha";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    TrilhaTO trilha = new TrilhaTO();
                    trilha.setId(rs.getLong("id_trilha"));
                    trilha.setNome(rs.getString("nm_trilha"));
                    trilha.setDescricao(rs.getString("nm_descricao"));
                    trilha.setAreaProfissional(rs.getString("nm_area_profissional"));
                    trilhas.add(trilha);
                }
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return trilhas;
    }

    public TrilhaTO findByCode(Long codigo) {
        TrilhaTO trilha = new TrilhaTO();
        String sql = "select * from t_skb_trilha where id_trilha=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                trilha.setId(codigo);
                trilha.setNome(rs.getString("nm_trilha"));
                trilha.setDescricao(rs.getString("nm_descricao"));
                trilha.setAreaProfissional(rs.getString("nm_area_profissional"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("\nErro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return trilha;
    }
}
