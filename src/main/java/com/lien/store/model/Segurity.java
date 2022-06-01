package com.lien.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Segurity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_segurity")
  private int id_segurity;

  @OneToOne
  @JoinColumn(name = "id_usuario_seg")
  private Usuario id_usuario_seg;

  @Column(name = "password")
  private String password;
}
