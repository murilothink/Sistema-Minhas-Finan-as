package com.minhasfinancas.Entidade.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table( name = "usuario", schema = "financas")
@Data
@Builder
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String email;

    @Column(name = "email")
    private String nome;

    @Column(name = "senha")

    private String senha;

}
