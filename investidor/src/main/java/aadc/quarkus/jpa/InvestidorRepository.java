package aadc.quarkus.jpa;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;


@ApplicationScoped
public class InvestidorRepository {

    @Inject
    EntityManager entityManager;

    public void persist(Investidor investidor) {
        entityManager.persist(investidor);
    }

    public Investidor findById (Long id) {
        return entityManager.find(Investidor.class, id);
    }


}
