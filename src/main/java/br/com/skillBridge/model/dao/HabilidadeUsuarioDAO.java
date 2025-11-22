package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.HabilidadeTO;
import br.com.skillBridge.model.dto.HabilidadeUsuarioTO;
import org.apache.camel.builder.endpoint.dsl.PulsarEndpointBuilderFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabilidadeUsuarioDAO {
    public ArrayList<HabilidadeUsuarioTO> findAll(Long idUsuario) {
        ArrayList<HabilidadeUsuarioTO> habilidadesUsuario = new ArrayList<>();

        String sql = "select * from t_skb_usuario_habilidade uh inner join t_skb_habilidade h\n" +
                "    on (uh.id_habilidade = h.id_habilidade)\n" +
                "    where id_usuario = ? \n" +
                "    order by id_usuario_habilidade desc";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    HabilidadeUsuarioTO habilidadeUsuario = new HabilidadeUsuarioTO();
                    HabilidadeTO habilidade = new HabilidadeTO();
                    habilidadeUsuario.setId(rs.getLong("id_usuario_habilidade"));
                    habilidadeUsuario.setNivel(rs.getString("nv_conhecimento"));
                    habilidadeUsuario.setDataCriacao(rs.getDate("dt_criacao").toLocalDate());
                    habilidade.setId(rs.getLong("id_habilidade"));
                    habilidade.setNome(rs.getString("nm_habilidade"));
                    habilidade.setCategoria(rs.getString("nm_categoria"));
                    habilidadeUsuario.setHabilidade(habilidade);
                    habilidadesUsuario.add(habilidadeUsuario);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return habilidadesUsuario;
    }

    public boolean delete(Long idHabilidadeUsuario) {
        String sql = "delete from t_skb_usuario_habilidade where id_usuario_habilidade=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, idHabilidadeUsuario);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return false;
    }
}
