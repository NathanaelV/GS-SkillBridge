package br.com.skillBridge.model.bo;

import br.com.skillBridge.model.dao.EmpresaDAO;
import br.com.skillBridge.model.dto.EmpresaTO;

import java.util.ArrayList;

public class EmpresaBO {
    private EmpresaDAO empresaDAO;

    public ArrayList<EmpresaTO> findAll() {
        empresaDAO = new EmpresaDAO();
        return empresaDAO.findAll();
    }
    
}
