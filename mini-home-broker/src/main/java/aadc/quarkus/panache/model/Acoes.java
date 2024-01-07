package aadc.quarkus.panache.model;

import aadc.quarkus.jdbc.Escriturador;
import jakarta.persistence.*;


@Entity
public class Acoes extends Investimento {

    @Column(name = "tipo_da_acao", length = 7)
    @Enumerated(EnumType.STRING)
    public TipoAcao tipoAcao;

    @Column(length = 5)
    public String ticker; // ex.: PETR3, acao ordinaria // PETR4, acao preferencial

    @Column(length = 100)
    public String empresa;

    // Many Acoes can belong to One Escriturador
    // One Escriturador can have Many Acoes
    @ManyToOne(cascade = CascadeType.PERSIST)
//    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "escriturador_fk")
    public Escriturador escriturador;

}






