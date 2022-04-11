package com.lien.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Recordatorio {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_recordatorio")
  private int id_recordatorio;

  @ManyToOne
  @JoinColumn(name = "id_usuario_recorda")
  private Usuario id_usuario_recorda;

  @Column(name = "motivo")
  private String motivo;

  @Column(name = "fecha")
  private Date fecha;
}
