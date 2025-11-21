package br.com.skillBridge.controller.resource;

import br.com.skillBridge.model.bo.HabilidadeUsuarioBO;
import br.com.skillBridge.model.bo.TrilhaUsuarioBO;
import br.com.skillBridge.model.bo.UsuarioBO;
import br.com.skillBridge.model.dto.HabilidadeUsuarioTO;
import br.com.skillBridge.model.dto.TrilhaUsuarioTO;
import br.com.skillBridge.model.dto.UsuarioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/usuario")
public class UsuarioResource {
    private UsuarioBO usuarioBO = new UsuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<UsuarioTO> resultado = usuarioBO.findAll();
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }

        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCodigo(@PathParam("codigo") Long codigo) {
        UsuarioTO resultado = usuarioBO.findByCode(codigo);
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }

        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid UsuarioTO usuario) {
        UsuarioTO resultado = usuarioBO.save(usuario);
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }

        response.entity(resultado);
        return response.build();
    }

    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid UsuarioTO usuario, @PathParam("codigo") Long codigo) {
        usuario.setId(codigo);
        UsuarioTO resultado = usuarioBO.update(usuario);
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }

        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{codigo}/trilha_usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllTrilha(@PathParam("codigo") Long codigo) {
        TrilhaUsuarioBO trilhaUsuarioBO = new TrilhaUsuarioBO();
        ArrayList<TrilhaUsuarioTO> resultado = trilhaUsuarioBO.findAll(codigo);
        Response.ResponseBuilder response;

        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }

        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("{codigo}/habilidade_usuario")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllHabilidade(@PathParam("codigo") Long codigo) {
        HabilidadeUsuarioBO habilidadeUsuarioBO = new HabilidadeUsuarioBO();
        ArrayList<HabilidadeUsuarioTO> resultado = habilidadeUsuarioBO.findAll(codigo);
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
