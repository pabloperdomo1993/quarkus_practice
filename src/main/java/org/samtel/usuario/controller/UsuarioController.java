package org.samtel.usuario.controller;

import jakarta.inject.Inject;
import org.samtel.usuario.gen.contract.V1UsuarioApi;
import org.samtel.usuario.gen.type.UsuarioTypeInput;
import org.samtel.usuario.gen.type.UsuarioTypeResponse;
import org.samtel.usuario.service.contract.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UsuarioController implements V1UsuarioApi {
    private static Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    @Inject
    UsuarioService usuarioService;

    @Override
    public List<UsuarioTypeResponse> crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicio crearUsuario");
        usuarioService.crearUsuario(usuarioTypeInput);
        return null;
    }
}
