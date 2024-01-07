package aadc.quarkus.panache.repository;

import aadc.quarkus.jdbc.Escriturador;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


@QuarkusTest
public class EscrituradorRepositoryTest {

    @Inject
    EscrituradorRepository escrituradorRepository;


    @Test
    @TestTransaction
    public void shoudlCreateAndFindAnEscriturador() {

        long contarTudo = escrituradorRepository.count();
        System.out.println(contarTudo);
        int listarTudo = escrituradorRepository.listAll().size();
        System.out.println(listarTudo);

        Assertions.assertEquals(contarTudo, listarTudo);
        Assertions.assertEquals(escrituradorRepository.listAllEscrituradorSorted().size(), listarTudo);


        Escriturador escriturador = new Escriturador();
        escriturador.setNome("nome");

        escrituradorRepository.persist(escriturador);
        Assertions.assertNotNull(escriturador.getId());


        Assertions.assertEquals(contarTudo + 1, escrituradorRepository.count()); // persistimos um escriturador, portanto, o esperado deve somar +1

        escriturador = escrituradorRepository.findById(escriturador.getId());
        Assertions.assertEquals("nome", escriturador.getNome());

        escrituradorRepository.deleteById(escriturador.getId());
        Assertions.assertEquals(contarTudo, escrituradorRepository.count());


    }


}
