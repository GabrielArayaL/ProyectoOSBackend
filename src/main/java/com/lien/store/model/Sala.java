package com.lien.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Sala {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_sala")
  private int id_sala;

  @OneToOne
  @JoinColumn(name = "id_tipo_sala_ts")
  private TipoSala id_tipo_sala_ts;

  @Column(name = "nombre")
  private String nombre;

  @Column(name = "fecha")
  private Date fecha;
}
