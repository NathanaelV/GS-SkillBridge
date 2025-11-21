package br.com.skillBridge.model.bo;

import br.com.skillBridge.model.dao.TrilhaUsuarioDAO;
import br.com.skillBridge.model.dto.TrilhaUsuarioTO;

import java.util.ArrayList;

public class TrilhaUsuarioBO {
    private TrilhaUsuarioDAO trilhaUsuarioDAO;

    public ArrayList<TrilhaUsuarioTO> findAll(Long idUsuario) {
        trilhaUsuarioDAO = new TrilhaUsuarioDAO();
        return trilhaUsuarioDAO.findAll(idUsuario);
    }

    public TrilhaUsuarioTO save(Long idUsuario, TrilhaUsuarioTO trilhaUsuarioTO) {
        trilhaUsuarioDAO = new TrilhaUsuarioDAO();
        return trilhaUsuarioDAO.save(idUsuario, trilhaUsuarioTO);
    }
}
