package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.MensajeRequest;
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

  @RequestMapping(value = URLMapping.Mensaje.SENDM, method = RequestMethod.POST)
  public ResponseEntity<?> enviarMensajeNormal(
      @RequestPart("payload") MensajeRequest payload, @RequestPart("file") MultipartFile imagen) {
    return mensajeService.crearMensajeMultimedia(payload, imagen);
  }

  @RequestMapping(value = URLMapping.Mensaje.SENDN, method = RequestMethod.POST)
  public ResponseEntity<?> enviarMensajeMultimedia(@RequestBody MensajeRequest payload) {
    return mensajeService.crearMensajeNormal(payload);
  }

  @RequestMapping(value = URLMapping.Mensaje.GET, method = RequestMethod.GET)
  public List<?> enviarMensaje(@PathVariable int id) {
    return mensajeService.getMensaje(id);
  }
}
