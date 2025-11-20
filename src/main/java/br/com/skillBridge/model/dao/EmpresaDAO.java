package br.com.skillBridge.model.dao;

import br.com.skillBridge.model.dto.EmpresaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaDAO {
    public ArrayList<EmpresaTO> findAll() {
        ArrayList<EmpresaTO> empresas = new ArrayList<EmpresaTO>();

        String sql = "select * from t_skb_empresa order by id_empresa";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    EmpresaTO empresa = new EmpresaTO();
                    empresa.setId(rs.getLong("id_empresa"));
                    empresa.setNome(rs.getString("nm_empresa"));
                    empresa.setEmail(rs.getString("nm_email"));
                    empresa.setSetor(rs.getString("nm_setor"));
                    empresas.add(empresa);
                }
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return empresas;
    }

    public EmpresaTO findByCode(Long codigo) {
        EmpresaTO empresa = new EmpresaTO();
        String sql = "select * from t_skb_empresa where id_empresa=?";

        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empresa.setId(rs.getLong("id_empresa"));
                empresa.setNome(rs.getString("nm_empresa"));
                empresa.setEmail(rs.getString("nm_email"));
                empresa.setSetor(rs.getString("nm_setor"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("\nErro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }

        return empresa;
    }
}
