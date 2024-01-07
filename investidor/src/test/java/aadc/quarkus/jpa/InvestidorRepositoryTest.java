package aadc.quarkus.jpa;


import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

@QuarkusTest
public class InvestidorRepositoryTest {

    @Inject
    InvestidorRepository investidorRepository;

    @Test
    @TestTransaction
    public void shoudlCreateAndFindAnInvestidor () throws SQLException {
        Investidor investidor = new Investidor("nome", "sobrenome", "email", 1994);

        investidorRepository.persist(investidor);
        Assertions.assertNotNull(investidor.getId());

        investidor = investidorRepository.findById(investidor.getId());
        Assertions.assertEquals("nome", investidor.getNome());
        Assertions.assertEquals("sobrenome", investidor.getSobrenome());
        Assertions.assertEquals("email", investidor.getEmail());
        Assertions.assertEquals(1994, investidor.getAnoNascimento());



    }

}
