package org.samtel.usuario.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.samtel.usuario.dao.UsuarioDao;
import org.samtel.usuario.entity.UsuarioEntity;
import org.samtel.usuario.gen.type.UsuarioTypeInput;
import org.samtel.usuario.service.contract.UsuarioService;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    UsuarioDao usuarioDao;

    @Transactional
    public UsuarioEntity crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setName(usuarioTypeInput.getName());
        usuarioEntity.setLastname(usuarioTypeInput.getLastname());

        usuarioDao.persist(usuarioEntity);

        return usuarioEntity;
    }
}
