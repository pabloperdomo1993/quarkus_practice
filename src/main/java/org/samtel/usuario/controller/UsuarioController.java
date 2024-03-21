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
    public Response crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicio crearUsuario");

        UsuarioTypeInput usuarioType = null;
        try {
            usuarioType = usuarioService.crearUsuario(usuarioTypeInput);
        } catch (ApplicationException e) {
            LOG.error(Constants.ERROR_SERVICIO + e.getMessage()+ "crearUsuarioController");
            return Response.status(Response.Status.BAD_REQUEST).entity(usuarioType).build();
        }

        LOG.info("Finaliza crear usuario Controller");
        return Response.status(Response.Status.CREATED).entity(usuarioType).build();
    }
}
