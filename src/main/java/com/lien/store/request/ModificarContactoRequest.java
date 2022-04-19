package com.lien.store.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModificarContactoRequest {

  private int id_contacto;
  private String nombre_contacto;
  private int numero_contacto;
}
