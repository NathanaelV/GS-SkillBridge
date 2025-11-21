package br.com.skillBridge.model.bo;

import br.com.skillBridge.model.dao.TrilhaCursoDAO;
import br.com.skillBridge.model.dto.CursoTO;

import java.util.ArrayList;

public class TrilhaCursoBO {
    private TrilhaCursoDAO trilhaCursoDAO;

    public ArrayList<CursoTO> findAll(Long idTrilha) {
        trilhaCursoDAO = new TrilhaCursoDAO();
        return trilhaCursoDAO.findAll(idTrilha);
    }
}
