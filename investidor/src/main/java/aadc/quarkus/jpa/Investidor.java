package aadc.quarkus.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "t_investidores")
public class Investidor {

    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String sobrenome;
    private String email;
    private Integer anoNascimento;

    public Investidor() {
    }

    public Investidor(String nome, String sobrenome, String email, Integer anoNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.anoNascimento = anoNascimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
}
