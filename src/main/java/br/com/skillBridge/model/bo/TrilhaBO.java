package br.com.skillBridge.model.bo;

import br.com.skillBridge.model.dao.TrilhaDAO;
import br.com.skillBridge.model.dao.TrilhaDAO;
import br.com.skillBridge.model.dto.TrilhaTO;
import br.com.skillBridge.model.dto.TrilhaTO;

import java.util.ArrayList;

public class TrilhaBO {
    private TrilhaDAO trilhaDAO;

    public ArrayList<TrilhaTO> findAll() {
        trilhaDAO = new TrilhaDAO();
        return trilhaDAO.findAll();
    }

    public TrilhaTO findByCode(Long codigo) {
        trilhaDAO = new TrilhaDAO();
        return trilhaDAO.findByCode(codigo);
    }
}
