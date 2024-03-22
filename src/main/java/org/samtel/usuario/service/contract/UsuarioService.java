package org.samtel.usuario.service.contract;

import jakarta.enterprise.context.ApplicationScoped;
import org.samtel.usuario.gen.type.UsuarioTypeInput;
import org.samtel.usuario.gen.type.UsuarioTypeResponse;

@ApplicationScoped
public interface UsuarioService {
    UsuarioTypeInput crearUsuario(UsuarioTypeInput usuarioTypeInput);
    UsuarioTypeResponse verUsuario(Integer idtblUser);
    UsuarioTypeResponse eliminarUsuario(Integer idtblUser);
}
