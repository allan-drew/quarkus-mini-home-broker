package aadc.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;


// Panache Entity is based on a JPA entity

// Simplifies JPA entities and repositories
    // public attributes
    // optional getters/setters
    // generated ID (comes from superclass PanacheEntity)
    // inherit CRUD/Query operations


@Entity
@Table(name = "t_investimentos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // single table is the default Inheritance strategy
public class Investimento extends PanacheEntity {

    @Column(nullable = false) // cannot be null
    public BigDecimal precoUnitario; // preco de uma acao ou preco de um tesouro (prefixado, ipca ou selic)

    @Column(length = 3000) // lenght of 3000, and can be null
    public String descricao;


}


