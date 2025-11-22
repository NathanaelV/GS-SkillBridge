package br.com.skillBridge.model.bo;

import br.com.skillBridge.model.dao.HabilidadeUsuarioDAO;
import br.com.skillBridge.model.dto.HabilidadeUsuarioTO;

import java.util.ArrayList;

public class HabilidadeUsuarioBO {
    private HabilidadeUsuarioDAO habilidadeUsuarioDAO;

    public ArrayList<HabilidadeUsuarioTO> findAll(Long idUsuario) {
        habilidadeUsuarioDAO = new HabilidadeUsuarioDAO();
        return habilidadeUsuarioDAO.findAll(idUsuario);
    }

    public boolean delete(Long idHabilidadeUsuario) {
        habilidadeUsuarioDAO = new HabilidadeUsuarioDAO();
        return habilidadeUsuarioDAO.delete(idHabilidadeUsuario);
    }
}
