package org.samtel.usuario.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.samtel.usuario.constant.Constants;
import org.samtel.usuario.controller.UsuarioController;
import org.samtel.usuario.dao.UsuarioDao;
import org.samtel.usuario.entity.UsuarioEntity;
import org.samtel.usuario.gen.type.UsuarioTypeInput;
import org.samtel.usuario.gen.type.UsuarioTypeResponse;
import org.samtel.usuario.service.contract.UsuarioService;
import org.samtel.usuario.utils.exception.ApplicationException;
import org.samtel.usuario.utils.mapper.UsuarioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {
    private static Logger LOG = LoggerFactory.getLogger(UsuarioController.class);
    @Inject
    UsuarioDao usuarioDao;

    @Inject
    UsuarioMapper usuarioMapper;
    @Transactional
    public UsuarioTypeInput crearUsuario(UsuarioTypeInput usuarioTypeInput) {
        LOG.info("Inicio crearUsuario");
        UsuarioTypeInput usuarioType = null;
        try {
            UsuarioEntity usuarioEntity = usuarioMapper.usuarioTypeToEntity(usuarioTypeInput);
            usuarioDao.persist(usuarioEntity);
            usuarioType = usuarioMapper.usuarioEntityToType(usuarioEntity);
        } catch (ApplicationException e){
            LOG.error(Constants.ERROR_SERVICIO + e.getMessage()+ " crearUsuarioServiceImpl");
        }
        LOG.info("Finaliza crear usuario ServiceImpl");
        return usuarioType;
    }

    @Transactional
    public UsuarioTypeResponse verUsuario(Integer idtblUser){
        LOG.info("Inicio verUsuario");
        long longIdtblUser = idtblUser.longValue();
        UsuarioEntity usuarioEntity = usuarioDao.findById(longIdtblUser);
        UsuarioTypeResponse usuarioTypeResponse = usuarioMapper.usuarioEntityToTypeResponse(usuarioEntity);
        LOG.info("Finaliza ver usuario ServiceImpl");
        return usuarioTypeResponse;
    }

    @Transactional
    public UsuarioTypeResponse eliminarUsuario(Integer idtblUser){
        LOG.info("Inicio eliminarUsuario");
        long longIdtblUser = idtblUser.longValue();
        UsuarioEntity usuarioEntity = usuarioDao.findById(longIdtblUser);
        UsuarioTypeResponse usuarioTypeResponse = usuarioMapper.usuarioEntityToTypeResponse(usuarioEntity);
        usuarioDao.delete(usuarioEntity);
        LOG.info("Finaliza eliminar usuario ServiceImpl");
        return usuarioTypeResponse;
    }
}
