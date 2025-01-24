package org.acme;

import jakarta.ws.rs.Produces;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/labseq")
/**
 * Recurso REST responsável por expor o cálculo da sequência Labseq.
 */
public class SequenceResource {

    @Inject
    SequenceService labseqService;
    
    @GET
    @Path("/{n}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Calcula o valor Labseq", description = "Retorna o valor da sequencia Labseq correspondente ao número fornecido.")
    @APIResponse(responseCode = "200", description = "Valor calculado com sucesso")
    @APIResponse(responseCode = "400", description = "Entrada inválida")
    @APIResponse(responseCode = "500", description = "Internal Server Error")
    public Response labseq(
        @Parameter(description = "Número para calcular Labseq", required = true) @PathParam("n") int n) {

            try {
                long value = labseqService.calculateLabseq(n);
                return Response.ok(new LabseqResponse(String.valueOf(value), "valid")).build();
            } catch (IllegalArgumentException e) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(new LabseqResponse("0", "invalid"))
                        .build();
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(new LabseqResponse("0", "internal_error"))
                        .build();
            }
    }
}
