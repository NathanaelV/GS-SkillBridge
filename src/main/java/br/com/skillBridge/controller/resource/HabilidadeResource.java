package br.com.skillBridge.controller.resource;

import br.com.skillBridge.model.bo.HabilidadeBO;
import br.com.skillBridge.model.dto.HabilidadeTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/habilidade")
public class HabilidadeResource {
    private HabilidadeBO habilidadeBO = new HabilidadeBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<HabilidadeTO> resultado = habilidadeBO.findAll();
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }

        response.entity(resultado);
        return response.build();
    }
}
