package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificarUsuarioRequest {

  private int id_usuario;
  private String nombre;
  private int telefono;
}
