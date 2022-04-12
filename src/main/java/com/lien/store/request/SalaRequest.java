package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SalaRequest {
  private String nombre_tipo_sala;
  private String nombre_sala;
  private int id_usuario;
  private Date fecha;
}
