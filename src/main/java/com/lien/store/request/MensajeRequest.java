package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensajeRequest {

  private int id_usuario;
  private int id_sala;
  private String nombre_msj;
  private String texto;
}
