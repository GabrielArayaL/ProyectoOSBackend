package com.lien.store.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Mensaje {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_mensaje")
  private int id_mensaje;

  @OneToOne
  @JoinColumn(name = "id_usuario_msj")
  private Usuario id_usuario_msj;

  @OneToOne
  @JoinColumn(name = "id_sala_msj")
  private Sala id_sala_msj;

  @OneToOne
  @JoinColumn(name = "id_tipo_msj")
  private TipoMensaje id_tipo_msj;

  /*@Column(name = "texto")
  @ColumnTransformer(
      read = "CAST(AES_DECRYPT(UNHEX(texto), 'ankon') as char(128))",
      write = "HEX(AES_ENCRYPT(?, 'ankon'))")
  private String texto;*/

  @Column(name = "texto")
  private String texto;

  @Column(name = "fecha")
  private Date fecha;

  @Column(name = "archivo")
  private byte[] archivo;

  /* @Column(name = "archivo")
  @ColumnTransformer(
      read = "CAST(AES_DECRYPT(UNHEX(archivo), 'ankon') as char(128))",
      write = "HEX(AES_ENCRYPT(?, 'ankon'))")
  private String archivo;*/
}
