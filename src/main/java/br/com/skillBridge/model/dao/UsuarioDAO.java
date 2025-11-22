package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.HabilidadeUsuarioTO;
import br.com.skillBridge.model.dto.UsuarioTO;
import oracle.jdbc.proxy.annotation.Pre;

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
                    usuario.setId(rs.getLong("id_usuario"));
                    usuario.setNome(rs.getString("nm_usuario"));
                    usuario.setEmail(rs.getString("nm_email"));
                    usuario.setSexo(rs.getString("sx_usuario"));
                    usuario.setDataNascimento(rs.getDate("dt_nascimento").toLocalDate());
                    usuario.setCpf(rs.getLong("nr_cpf"));
                    usuario.setIdEmpresa(rs.getLong("id_empresa"));
                    usuarios.add(usuario);
                }
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
                usuario.setId(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nm_usuario"));
                usuario.setEmail(rs.getString("nm_email"));
                usuario.setSexo(rs.getString("sx_usuario"));
                usuario.setDataNascimento(rs.getDate("dt_nascimento").toLocalDate());
                usuario.setCpf(rs.getLong("nr_cpf"));
                usuario.setIdEmpresa(rs.getLong("id_empresa"));
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
        String sql = "insert into t_skb_usuario (nm_usuario, nm_email, sn_usuario, sx_usuario, dt_nascimento, nr_cpf, id_empresa)" +
                " VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql, new String[]{"id_usuario"})) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getSexo());
            ps.setDate(5, Date.valueOf(usuario.getDataNascimento()));
            ps.setLong(6, usuario.getCpf());
            ps.setLong(7, usuario.getIdEmpresa());

            if (ps.executeUpdate() > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        long codigoUsuario = rs.getLong(1);
                        usuario.setId(codigoUsuario);

                        String sqlHabilidadeUsuario = "insert into T_SKB_USUARIO_HABILIDADE (nv_conhecimento, id_usuario, id_habilidade, dt_criacao)" +
                                " values (?,?,?, sysdate)";
                        String[] colunasRetorno = {"id_usuario_habilidade", "dt_criacao"};

                        for (HabilidadeUsuarioTO habilidadeUsuario : usuario.getHabilidadesUsuario()) {

                            try (PreparedStatement ps2 = ConnectionFactory.getConnection().prepareStatement(sqlHabilidadeUsuario, colunasRetorno)) {
                                ps2.setString(1, habilidadeUsuario.getNivel());
                                ps2.setLong(2, codigoUsuario);
                                ps2.setLong(3, habilidadeUsuario.getHabilidade().getId());

                                if (ps2.executeUpdate() <= 0){
                                    return null;
                                }

                                try (ResultSet rs2 = ps2.getGeneratedKeys()) {
                                    if (rs2.next()) {
                                        habilidadeUsuario.setId(rs2.getLong(1));
                                        habilidadeUsuario.setDataCriacao(rs2.getDate(2).toLocalDate());
                                    }
                                }

                            } catch (SQLException e) {
                                System.out.println("Erro ao salvar habilidade do usuario: " + e.getMessage());
                            }
                        }
                    }
                }

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
        String sql = "update t_skb_usuario set nm_usuario=?, nm_email=?, sx_usuario=?, dt_nascimento=?, nr_cpf=?, id_empresa=? where id_usuario=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSexo());
            ps.setDate(4, Date.valueOf(usuario.getDataNascimento()));
            ps.setLong(5, usuario.getCpf());
            ps.setLong(5, usuario.getIdEmpresa());
            ps.setLong(6, usuario.getId());

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
