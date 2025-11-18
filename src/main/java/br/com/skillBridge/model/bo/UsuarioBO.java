package br.com.skillBridge.model.bo;

import br.com.skillBridge.model.dao.UsuarioDAO;
import br.com.skillBridge.model.dto.UsuarioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

public class UsuarioBO {
    private UsuarioDAO usuarioDAO;

    public ArrayList<UsuarioTO> findAll() {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findAll();
    }

    public UsuarioTO findByCode(Long codigo) {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.findByCode(codigo);
    }

    public UsuarioTO save(UsuarioTO usuario) {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.save(usuario);
    }

    public UsuarioTO update(UsuarioTO usuario) {
        usuarioDAO = new UsuarioDAO();
        return usuarioDAO.update(usuario);
    }

}
