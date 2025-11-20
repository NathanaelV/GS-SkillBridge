package br.com.skillBridge.model.bo;

import br.com.skillBridge.model.dao.CursoDAO;
import br.com.skillBridge.model.dto.CursoTO;

public class CursoBO {
    private CursoDAO cursoDAO;

    public CursoTO findByCode(Long codigo) {
        cursoDAO = new CursoDAO();
        return cursoDAO.findByCode(codigo);
    }
}
