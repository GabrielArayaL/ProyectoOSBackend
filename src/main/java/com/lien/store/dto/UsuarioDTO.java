package com.lien.store.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDTO {
  private int id_usuario;
  private String nombre;
  private int telefono;
}
