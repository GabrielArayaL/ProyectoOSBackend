package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearUsuarioRequest {
  private String nombre;
  private String password;
  private int telefono;
}
