package org.samtel.usuario.service.contract;

import jakarta.enterprise.context.ApplicationScoped;
import org.samtel.usuario.gen.type.UsuarioTypeInput;

@ApplicationScoped
public interface UsuarioService {
    Object crearUsuario(UsuarioTypeInput usuarioTypeInput);
}
