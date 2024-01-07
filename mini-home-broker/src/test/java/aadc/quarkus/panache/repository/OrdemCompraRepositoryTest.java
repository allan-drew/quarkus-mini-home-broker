package aadc.quarkus.panache.repository;

import aadc.quarkus.jdbc.Escriturador;
import aadc.quarkus.jpa.Investidor;
import aadc.quarkus.panache.model.Acoes;
import aadc.quarkus.panache.model.OrdemCompra;
import aadc.quarkus.panache.model.TipoAcao;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.SQLException;

@QuarkusTest
public class OrdemCompraRepositoryTest {

    @Inject
    InvestidorRepository investidorRepository;

    @Test
    @TestTransaction
    public void shoudlCreateAndFindAOrdemCompra () {

        //----------------------------------------------------------------------------------------------------
        // To create a OrdemCompra, we need a Investimento. In this case, we are going to create Acoes
        // And, to create Acoes, we need a Escriturador

        Escriturador escrituradorTest = new Escriturador("Bradesco");

        Acoes acaoPetro = new Acoes();
        acaoPetro.precoUnitario = BigDecimal.valueOf(36.05);
        acaoPetro.empresa = "Petrobras";
        acaoPetro.descricao = "Petróleo Brasileiro S.A. é uma empresa de capital aberto, cujo acionista majoritário é o Governo do Brasil, sendo, portanto, uma empresa estatal de economia mista.";
        acaoPetro.tipoAcao = TipoAcao.ACAO_ON;
        acaoPetro.ticker = "PETR3";
        acaoPetro.escriturador = escrituradorTest;

        Acoes.persist(acaoPetro);
        //----------------------------------------------------------------------------------------------------


        //----------------------------------------------------------------------------------------------------
        // To create a OrdemCompra, we need a Investidor
        Investidor investidorTubarao = new Investidor("O Tubarão", "Da Bolsa", "investidor_tubarao@gmail.com", 1994);

        // As we Injected InvestidorRepository, we can persist the Investidor
        investidorRepository.persist(investidorTubarao);


        //----------------------------------------------------------------------------------------------------
        // Creates a OrdemCompra
        OrdemCompra ordemCompra = new OrdemCompra();
        ordemCompra.investidor = investidorTubarao;
        ordemCompra.investimento = acaoPetro;

        OrdemCompra.persist(ordemCompra);
        //----------------------------------------------------------------------------------------------------


        ordemCompra = OrdemCompra.encontrarPeloId(ordemCompra.id).orElseThrow(EntityNotFoundException::new);


    }

}
