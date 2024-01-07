package aadc.quarkus.jdbc;


import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


@QuarkusTest
public class EscrituradorRepositoryTest {

    @Inject
    EscrituradorRepository escrituradorRepository;

    @Test
    public void shoudlCreateAndFindAnEscriturador () throws SQLException {
        Escriturador escriturador = new Escriturador("nome");

        escrituradorRepository.persist(escriturador);
        Assertions.assertNotNull(escriturador.getId());

        escriturador = escrituradorRepository.findById(escriturador.getId());
        Assertions.assertEquals("nome", escriturador.getNome());

    }


}
