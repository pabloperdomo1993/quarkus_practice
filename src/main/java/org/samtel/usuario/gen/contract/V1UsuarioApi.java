package org.samtel.usuario.gen.contract;

import org.samtel.usuario.gen.type.UsuarioTypeInput;
import org.samtel.usuario.gen.type.UsuarioTypeResponse;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;




import java.io.InputStream;
import java.util.Map;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;


@Path("/v1/es/crearUsuario")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-18T08:17:25.618224300-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public interface V1UsuarioApi {

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    List<UsuarioTypeResponse> crearUsuario(@Valid UsuarioTypeInput usuarioTypeInput);
}
