package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificarRecordatorioRequest {

  private int id_recordatorio;
  private String motivo;
  private String fecha;
}
