package aadc.quarkus.panache.model;

import aadc.quarkus.jpa.Investidor;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Optional;


@Entity
@Table(name = "t_ordem_compra")
public class OrdemCompra extends PanacheEntity {

    @Column(name = "data_ordem_de_compra", nullable = false)
    public LocalDate date = LocalDate.now();

    @ManyToOne(cascade = CascadeType.PERSIST)
//    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "investidor_fk")
    public Investidor investidor;

    @ManyToOne(cascade = CascadeType.PERSIST)
//    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "investimento_fk")
    public Investimento investimento;


    // When you add queries directly into the entity class in a Panache-based application, it's typically referred to as using "custom queries" or "custom methods"
    // within the Panache entity. Panache is a set of libraries provided by Quarkus, a Java framework, to simplify data access and persistence.
    // Encontrando uma ordem de compra pelo id (lembrando que a panache entity já inclui um id na classe automaticamente)
    public static Optional<OrdemCompra> encontrarPeloId(Long id) {
        return OrdemCompra.find("id", id).firstResultOptional();
    }


}
