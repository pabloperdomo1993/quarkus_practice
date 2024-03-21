package org.samtel.usuario.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.samtel.usuario.dao.UsuarioDao;
import org.samtel.usuario.entity.UsuarioEntity;
import org.samtel.usuario.gen.type.UsuarioTypeInput;
import org.samtel.usuario.service.contract.UsuarioService;
import org.samtel.usuario.utils.mapper.UsuarioMapper;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    UsuarioDao usuarioDao;

    @Inject
    UsuarioMapper usuarioMapper;
    @Transactional
    public UsuarioTypeInput crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        UsuarioEntity usuarioEntity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
        usuarioDao.persist(usuarioEntity);
        UsuarioTypeInput usuarioType = usuarioMapper.usuarioEntityToType(usuarioEntity);
        return usuarioType;
    }
}
