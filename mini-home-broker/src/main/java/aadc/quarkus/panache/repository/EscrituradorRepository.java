package aadc.quarkus.panache.repository;


import aadc.quarkus.jdbc.Escriturador;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


@ApplicationScoped
public class EscrituradorRepository implements PanacheRepository<Escriturador> {

    public List<Escriturador> listAllEscrituradorSorted() {
        return listAll(Sort.ascending("nome"));
    }

}
