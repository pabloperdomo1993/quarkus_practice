package org.samtel.usuario.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.samtel.usuario.entity.UsuarioEntity;

@ApplicationScoped
public class UsuarioDao implements PanacheRepository<UsuarioEntity> {

}
