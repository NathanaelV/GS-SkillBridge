package br.com.skillBridge.controller.resource;

import br.com.skillBridge.model.bo.HabilidadeUsuarioBO;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("habilidade_usuario")
public class HabilidadeUsuarioResource {
    HabilidadeUsuarioBO habilidadeUsuarioBO = new HabilidadeUsuarioBO();

    @DELETE
    @Path("{codigo}")
    public Response delete(@PathParam("codigo") Long codigo) {
        Response.ResponseBuilder response;

        if (habilidadeUsuarioBO.delete(codigo)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }

        return response.build();
    }

}
