package aadc.quarkus.panache.restresource;


import aadc.quarkus.jdbc.Escriturador;
import aadc.quarkus.panache.model.Investimento;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("/api/investimentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InvestimentoResource {

    @GET
    public List<Investimento> listAllInvestimentosDisponiveis() {
        return Investimento.listAll();
    }

    @GET
    @Path("{id}")
    public PanacheEntityBase findInvestimentoById(@PathParam("id") Long id) {
        return Investimento.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }


    // With this method we will create the Investimento, and send back de URL of this new Investimento.
    // In this case, we make in the RESTful way
    @Transactional
    @POST
    public Response persistInvestimento(Investimento investimento, @Context UriInfo uriInfo) {
        Investimento.persist(investimento);

        // build the URI of the new Investimento
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(investimento.id));
        return Response.created(builder.build()).build();
    }


    @Transactional
    @DELETE
    @Path("{id}")
    public void deleteInvestimento(@PathParam("id") Long id) {
        Investimento.deleteById(id);
    }


}
