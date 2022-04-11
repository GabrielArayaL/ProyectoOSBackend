package com.lien.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TipoMensaje {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_tipo_mensaje")
  private int id_tipo_mensaje;

  @Column(name = "nombre")
  private String nombre;
}
