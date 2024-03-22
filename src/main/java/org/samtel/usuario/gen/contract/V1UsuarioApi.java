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


@Path("/v1/es")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2024-03-22T15:09:51.421527800-05:00[America/Bogota]", comments = "Generator version: 7.4.0")
public interface V1UsuarioApi {

    @POST
    @Path("/actualizarUsuario/{idtbl_user}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response actualizarUsuario(@PathParam("idtbl_user") @Min(1) Integer idtblUser,@Valid UsuarioTypeInput usuarioTypeInput);

    @GET
    @Path("/borrarUsuarioPorId/{idtbl_user}")
    @Produces({ "application/json" })
    Response borrarUsuarioPorId(@PathParam("idtbl_user") @Min(1) Integer idtblUser);

    @GET
    @Path("/buscarUsuarioPorId/{idtbl_user}")
    @Produces({ "application/json" })
    Response buscarUsuarioPorId(@PathParam("idtbl_user") @Min(1) Integer idtblUser);

    @POST
    @Path("/crearUsuario")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response crearUsuario(@Valid UsuarioTypeInput usuarioTypeInput);
}
