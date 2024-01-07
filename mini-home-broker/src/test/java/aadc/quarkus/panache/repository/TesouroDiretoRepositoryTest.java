package aadc.quarkus.panache.repository;

import aadc.quarkus.panache.model.TesouroDireto;
import aadc.quarkus.panache.model.TipoTesouro;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;


@QuarkusTest
public class TesouroDiretoRepositoryTest {

    @Test
    @TestTransaction
    public void shoudlCreateAndFindAnInvestimento () throws SQLException {

        long contarTudo = TesouroDireto.count();
        int listarTudo = TesouroDireto.listAll().size();
        Assertions.assertEquals(contarTudo, listarTudo);

        TesouroDireto tesouroDireto = new TesouroDireto();
        tesouroDireto.investimentoMinimo = 30.0;
        tesouroDireto.tipoTesouro = TipoTesouro.PREFIXADO;
        tesouroDireto.rentabilidadeAnual = 10.5;
        tesouroDireto.vencimento = LocalDate.of(2029, 01, 01);
        tesouroDireto.descricao = "Tesouro Prefixado 2099";
        tesouroDireto.precoUnitario = BigDecimal.valueOf(612.35);

        TesouroDireto.persist(tesouroDireto);
        Assertions.assertNotNull(tesouroDireto.id);

        Assertions.assertEquals(contarTudo + 1, TesouroDireto.count()); // persistimos um tesouro direto, portanto, o esperado deve somar +1

        tesouroDireto = TesouroDireto.findById(tesouroDireto.id);
        Assertions.assertEquals("Tesouro Prefixado 2099", tesouroDireto.descricao);

        tesouroDireto.deleteById(tesouroDireto.id);
        Assertions.assertEquals(contarTudo, tesouroDireto.count());


    }


}
