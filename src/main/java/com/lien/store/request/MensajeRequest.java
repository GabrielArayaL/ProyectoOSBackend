package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MensajeRequest {

  private String nombre_mensaje;
  private int id_usuario;
  private int id_sala;
  private int id_tipo;
  private byte[] texto;
  private Date fecha;
  private byte[] archivo;
}
