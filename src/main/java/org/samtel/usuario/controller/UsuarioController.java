package org.samtel.usuario.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.samtel.usuario.constant.Constants;
import org.samtel.usuario.gen.contract.V1UsuarioApi;
import org.samtel.usuario.gen.type.UsuarioTypeInput;
import org.samtel.usuario.gen.type.UsuarioTypeResponse;
import org.samtel.usuario.service.contract.UsuarioService;
import org.samtel.usuario.utils.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UsuarioController implements V1UsuarioApi {
    private static Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    @Inject
    UsuarioService usuarioService;

    @Override
    public Response borrarUsuarioPorId(Integer idtblUser) {
        LOG.info("Inicio eliminarUsuario");
        UsuarioTypeResponse usuarioResponse = null;
        try {
            usuarioResponse = usuarioService.eliminarUsuario(idtblUser);
        } catch (ApplicationException e) {
            LOG.error(Constants.ERROR_SERVICIO + e.getMessage()+ " eliminarUsuarioController");
            return Response.status(Response.Status.BAD_REQUEST).entity(usuarioResponse).build();
        }
        LOG.info("Finaliza eliminar usuario Controller");
        return Response.status(Response.Status.CREATED).entity(usuarioResponse).build();
    }

    @Override
    public Response buscarUsuarioPorId(Integer idtblUser) {
        LOG.info("Inicio verUsuario");
        UsuarioTypeResponse usuarioResponse = null;
        try {
            usuarioResponse = usuarioService.verUsuario(idtblUser);
        } catch (ApplicationException e) {
            LOG.error(Constants.ERROR_SERVICIO + e.getMessage()+ " verUsuarioController");
            return Response.status(Response.Status.BAD_REQUEST).entity(usuarioResponse).build();
        }
        LOG.info("Finaliza ver usuario Controller");
        return Response.status(Response.Status.CREATED).entity(usuarioResponse).build();
    }

    @Override
    public Response crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicio crearUsuario");
        UsuarioTypeInput usuarioType = null;
        try {
            usuarioType = usuarioService.crearUsuario(usuarioTypeInput);
        } catch (ApplicationException e) {
            LOG.error(Constants.ERROR_SERVICIO + e.getMessage()+ " crearUsuarioController");
            return Response.status(Response.Status.BAD_REQUEST).entity(usuarioType).build();
        }
        LOG.info("Finaliza crear usuario Controller");
        return Response.status(Response.Status.CREATED).entity(usuarioType).build();
    }
}
