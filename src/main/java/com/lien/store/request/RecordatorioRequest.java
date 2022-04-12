package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RecordatorioRequest {

  private int id_usuario;
  private String motivo;
  private Date fecha;
}
