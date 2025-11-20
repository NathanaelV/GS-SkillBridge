package br.com.skillBridge.controller.resource;

import br.com.skillBridge.model.bo.TrilhaBO;
import br.com.skillBridge.model.dto.TrilhaTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/trilha")
public class TrilhaResource {
    private TrilhaBO trilhaBO = new TrilhaBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<TrilhaTO> resultado = trilhaBO.findAll();
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
