package aadc.quarkus.panache.page;

import aadc.quarkus.panache.model.OrdemCompra;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;


@Path("/page/")
@Produces(MediaType.TEXT_HTML)
public class OrdemCompraPage {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance ordemCompra (OrdemCompra ordemCompra);
        public static native TemplateInstance ordensCompra (List<OrdemCompra> ordensCompra);
    }

    @GET
    @Path("/ordemcompra/{id}")
    public TemplateInstance showOrdemCompraById(@PathParam("id") Long id) {
        return Templates.ordemCompra(OrdemCompra.findById(id));
    }

    @GET
    @Path("/ordemcompra")
    public TemplateInstance showAllOrdemCompra() {
        return Templates.ordensCompra(OrdemCompra.listAll());
    }

}
