package aadc.quarkus.panache.repository;


import aadc.quarkus.jpa.Investidor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class InvestidorRepository implements PanacheRepository<Investidor> {

    public List<Investidor> listAllDans() {
        return list("nome = 'Dan'", Sort.by("sobrenome"));
    }

}
