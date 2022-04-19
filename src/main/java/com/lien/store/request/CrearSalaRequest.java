package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearSalaRequest {
  private String nombre_tipo_sala;
  private String nombre_sala;
  private int id_usuario;
  private String fecha;
}
