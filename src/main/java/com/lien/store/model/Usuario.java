package com.lien.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Usuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_usuario")
  private int id_usuario;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "telefono")
  private int telefono;
}
