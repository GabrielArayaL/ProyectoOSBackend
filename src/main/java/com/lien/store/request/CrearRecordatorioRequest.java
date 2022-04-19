package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearRecordatorioRequest {

  private int id_usuario;
  private String motivo;
  private String fecha;
}
