package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearContactoRequest {

  private int id_usuario;
  private String nombre_contacto;
  private int numero;
}
