package nl.nxcodes.rest.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import nl.nxcodes.rest.dto.response.ExceptionResponseDTO;

public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {
    @Override
    public Response toResponse(WebApplicationException e) {
        ExceptionResponseDTO dto = new ExceptionResponseDTO(e.getMessage());

        return Response.status(e.getResponse().getStatus()).entity(dto).build();
    }
}
