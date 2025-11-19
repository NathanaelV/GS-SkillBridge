package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.HabilidadeTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabilidadeDAO {
    public ArrayList<HabilidadeTO> findAll() {
        ArrayList<HabilidadeTO> habilidades = new ArrayList<HabilidadeTO>();

        String sql = "select * from t_skb_habilidade order by id_habilidade";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    HabilidadeTO habilidade = new HabilidadeTO();
                    habilidade.setCodigo(rs.getLong("id_habilidade"));
                    habilidade.setNome(rs.getString("nm_habilidade"));
                    habilidade.setCategoria(rs.getString("nm_categoria"));
                    habilidades.add(habilidade);
                }
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return habilidades;
    }
    
}
