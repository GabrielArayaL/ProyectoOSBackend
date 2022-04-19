package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.MensajeRequest;
import com.lien.store.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = URLMapping.Mensaje.URL)
public class MensajeController {
  @Autowired MensajeService mensajeService;

  @RequestMapping(value = URLMapping.Mensaje.SEND, method = RequestMethod.POST)
  public ResponseEntity<?> enviarMensaje(
      @PathVariable String nombre_msj,
      @RequestBody MensajeRequest payload,
      @PathVariable Integer id_usuario,
      @PathVariable Integer id_sala,
      @PathVariable String texto,
      @PathVariable String fecha) {
    return mensajeService.crearMensaje(payload, nombre_msj, id_usuario, id_sala, texto, fecha);
  }
}
