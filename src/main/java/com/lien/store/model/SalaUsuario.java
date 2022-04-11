package com.lien.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class SalaUsuario {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_sala_usuario")
  private int id_sala_usuario;

  @OneToOne
  @JoinColumn(name = "id_sala_su")
  private Sala id_sala_su;

  @OneToOne
  @JoinColumn(name = "id_usuario_su")
  private Usuario id_usuario_su;
}
