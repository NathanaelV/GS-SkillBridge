package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {
    public ArrayList<UsuarioTO> findAll() {
        ArrayList<UsuarioTO> usuarios = new ArrayList<UsuarioTO>();

        String sql = "select * from t_skb_usuario order by id_usuario";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    UsuarioTO usuario = new UsuarioTO();
                    usuario.setCodigo(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nm_usuario"));
                    usuario.setEmail(rs.getString("nm_email"));
                    usuario.setSexo(rs.getString("sx_usuario"));
                    usuario.setDataNascimento(rs.getDate("dt_nascimento").toLocalDate());
                    usuario.setCpf(rs.getLong("nr_cpf"));
                    usuarios.add(usuario);
                }

                System.out.println("\nFim do While\n");
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return usuarios;
    }

    public UsuarioTO findByCode(Long codigo) {
        UsuarioTO usuario = new UsuarioTO();
        String sql = "select * from t_skb_usuario where id_usuario=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setCodigo(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nm_usuario"));
                usuario.setEmail(rs.getString("nm_email"));
                usuario.setSexo(rs.getString("sx_usuario"));
                usuario.setDataNascimento(rs.getDate("dt_nascimento").toLocalDate());
                usuario.setCpf(rs.getLong("nr_cpf"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("\nErro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return usuario;
    }
    
    
}
