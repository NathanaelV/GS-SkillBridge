package br.com.skillBridge.model.bo;

import br.com.skillBridge.model.dao.HabilidadeDAO;
import br.com.skillBridge.model.dto.HabilidadeTO;

import java.util.ArrayList;

public class HabilidadeBO {
    private HabilidadeDAO habilidadeDAO;

    public ArrayList<HabilidadeTO> findAll() {
        habilidadeDAO = new HabilidadeDAO();
        return habilidadeDAO.findAll();
    }
}
