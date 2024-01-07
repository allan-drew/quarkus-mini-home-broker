package aadc.quarkus.panache.page;


import aadc.quarkus.panache.model.Acoes;
import aadc.quarkus.panache.model.TesouroDireto;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/page/investimentos")
@Produces(MediaType.TEXT_HTML)
public class InvestimentoPage {

    @CheckedTemplate
    public static class Templates {
          public static native TemplateInstance acao (Acoes acao);
          public static native TemplateInstance acoes (List<Acoes> acoes);

          public static native TemplateInstance tesouroDireto (TesouroDireto tesouroDireto);
          public static native TemplateInstance tesourosDireto (List<TesouroDireto> tesourosDireto);
    }

    @GET
    @Path("/acoes/{id}")
    public TemplateInstance showAcaoById(@PathParam("id") Long id) {
        return Templates.acao(Acoes.findById(id));
    }

    @GET
    @Path("/acoes")
    public TemplateInstance showAllAcoes() {
        return Templates.acoes(Acoes.listAll());
    }

    @GET
    @Path("/tesourodireto/{id}")
    public TemplateInstance showTesouroDiretoById(@PathParam("id") Long id) {
        return Templates.tesouroDireto(TesouroDireto.findById(id));
    }

    @GET
    @Path("/tesourodireto")
    public TemplateInstance showAllTesourosDireto() {
        return Templates.tesourosDireto(TesouroDireto.listAll());
    }


}
