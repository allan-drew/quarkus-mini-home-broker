package aadc.quarkus.panache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;


@Entity
public class TesouroDireto extends Investimento {

    @Column(name = "rentabilidade_anual_do_titulo")
    public Double rentabilidadeAnual;

    @Column(name = "investimento_minimo")
    public Double investimentoMinimo;

    @Column(name = "tipo_do_tesouro", length = 10)
    @Enumerated(EnumType.STRING)
    public TipoTesouro tipoTesouro;

    @Column(name = "data_de_vencimento")
    public LocalDate vencimento;

}
