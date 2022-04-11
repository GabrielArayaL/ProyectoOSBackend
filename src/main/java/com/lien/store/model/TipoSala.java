package com.lien.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TipoSala {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_tipo_sala")
  private int id_tipo_sala;

  @Column(name = "nombre")
  private String nombre;
}
