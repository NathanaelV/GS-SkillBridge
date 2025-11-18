package br.com.skillBridge.model.bo;

import br.com.skillBridge.model.dao.UsuarioDAO;
import br.com.skillBridge.model.dto.UsuarioTO;

import java.util.ArrayList;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO;

    public ArrayList<UsuarioTO> findAll() {
        usuarioDAO = new UsuarioDAO();
        // Implementação da regra de negócio.
        return usuarioDAO.findAll();
    }

    public UsuarioTO findByCode(Long codigo) {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findByCode(codigo);
    }
}
