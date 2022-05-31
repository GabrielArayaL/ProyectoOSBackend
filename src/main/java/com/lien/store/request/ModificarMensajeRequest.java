package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificarMensajeRequest {

  private int id_mensaje;
  private String texto;
}
