package aadc.quarkus.panache.restresource;


import aadc.quarkus.jdbc.Escriturador;
import aadc.quarkus.panache.repository.EscrituradorRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("/api/escrituradores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS) // all the methods use SUPPORTS, except persist and delete (they use REQUIRED, as its default)
public class EscrituradorResource {

    @Inject
    EscrituradorRepository repository;

    @GET
    public List<Escriturador> listAllEscrituradoresSorted() {
        return repository.listAllEscrituradorSorted();
    }

    @GET
    @Path("{id}")
    public Escriturador findEscrituradorById(@PathParam("id") Long id) {
        return repository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    // With this method we will create the Escriturador, and send back de URL of this new Escriturador.
    // In this case, we make in the RESTful way
    @Transactional
    @POST
    public Response persistEscriturador(Escriturador escriturador, @Context UriInfo uriInfo) {
        repository.persist(escriturador);

        // build the URI of the new Escriturador
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(escriturador.getId()));
        return Response.created(builder.build()).build();
    }


    @Transactional
    @DELETE
    @Path("{id}")
    public void deleteEscriturador(@PathParam("id") Long id) {
        repository.deleteById(id);
    }


}

