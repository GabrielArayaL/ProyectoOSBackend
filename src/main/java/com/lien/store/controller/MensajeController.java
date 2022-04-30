package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = URLMapping.Mensaje.URL)
public class MensajeController {
  @Autowired MensajeService mensajeService;

  @RequestMapping(value = URLMapping.Mensaje.SEND, method = RequestMethod.POST)
  public ResponseEntity<?> enviarMensaje(
      @PathVariable String nombre_msj,
      @RequestParam MultipartFile imagen,
      @PathVariable Integer id_usuario,
      @PathVariable Integer id_sala,
      @PathVariable String texto) {
    return mensajeService.crearMensaje(imagen, nombre_msj, id_usuario, id_sala, texto);
  }

  @RequestMapping(value = URLMapping.Mensaje.GET, method = RequestMethod.GET)
  public List<?> enviarMensaje(@PathVariable int id) {
    return mensajeService.getMensaje(id);
  }
}
