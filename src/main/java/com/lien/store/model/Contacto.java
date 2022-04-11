package com.lien.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Contacto {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_contacto")
  private int id_contacto;

  @OneToOne
  @JoinColumn(name = "id_usuario1_contac")
  private Usuario id_usuario1_contact;

  @OneToOne
  @JoinColumn(name = "id_usuario2_contac")
  private Usuario id_usuario2_contact;
}
