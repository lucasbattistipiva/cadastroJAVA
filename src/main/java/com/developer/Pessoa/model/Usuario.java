package com.developer.Pessoa.model;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;

    public Usuario (){}

    public Usuario( String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String toString(){
        return String.format("   |Código: %d "+
                "  |Nome: %s "+
                "  |Sobrenome: %s %n",
                getId(), getNome(),getSobrenome());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }
}
