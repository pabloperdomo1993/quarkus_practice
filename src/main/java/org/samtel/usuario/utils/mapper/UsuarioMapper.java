package org.samtel.usuario.utils.mapper;

import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;
import org.samtel.usuario.entity.UsuarioEntity;
import org.samtel.usuario.gen.type.UsuarioTypeInput;
import org.samtel.usuario.gen.type.UsuarioTypeResponse;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioMapper {
    public UsuarioEntity usuarioTypeToEntity(UsuarioTypeInput usuarioType) {

        return new ModelMapper().map(usuarioType, UsuarioEntity.class);
    }
    public UsuarioTypeInput usuarioEntityToType(UsuarioEntity usuario) {
        return new ModelMapper().map(usuario, UsuarioTypeInput.class);
    }
    public UsuarioTypeResponse usuarioEntityToTypeResponse(UsuarioEntity usuario) {
        return new ModelMapper().map(usuario, UsuarioTypeResponse.class);
    }
    public List<UsuarioEntity> usuarioTypeListToEntity(
            List<UsuarioTypeInput> usuarioTypeList) {
        return usuarioTypeList.stream().map(usuario -> usuarioTypeToEntity(usuario))
                .collect(Collectors.toList());
    }
    public UsuarioEntity clienteTypeToEntity(UsuarioTypeInput usuarioTypeInput) {
        return new ModelMapper().map(usuarioTypeInput, UsuarioEntity.class);
    }
    public UsuarioTypeResponse usuarioTypeToTypeResponse(UsuarioTypeInput usuarioTypeInput) {
        return new ModelMapper().map(usuarioTypeInput, UsuarioTypeResponse.class);
    }
}
