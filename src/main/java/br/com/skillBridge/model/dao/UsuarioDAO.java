package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.UsuarioTO;

import java.sql.Date;
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

    public UsuarioTO save(UsuarioTO usuario) {
        String sql = "insert into t_skb_usuario (nm_usuario, nm_email, sn_usuario, sx_usuario, dt_nascimento, nr_cpf)" +
                " VALUES (?,?,?,?,?,?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql, new String[]{"id_usuario"})) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getSexo());
            ps.setDate(5, Date.valueOf(usuario.getDataNascimento()));
            ps.setLong(6, usuario.getCpf());

            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        usuario.setCodigo(rs.getLong(1));
                    }
                }

                System.out.println("\nAqui o usuário retorna\n");

                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("\nErro na criação: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return null;
    }

    public UsuarioTO update(UsuarioTO usuario) {
        String sql = "update t_skb_usuario set nm_usuario=?, nm_email=?, sx_usuario=?, dt_nascimento=?, nr_cpf=? where id_usuario=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSexo());
            ps.setDate(4, Date.valueOf(usuario.getDataNascimento()));
            ps.setLong(5, usuario.getCpf());
            ps.setLong(6, usuario.getCodigo());

            if (ps.executeUpdate() > 0) {
                return usuario;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return null;
    }
    
    
}
