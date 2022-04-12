package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.MensajeRequest;
import com.lien.store.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URLMapping.Mensaje.URL)
public class MensajeController {
  @Autowired MensajeService mensajeService;

  @RequestMapping(value = URLMapping.Mensaje.SEND, method = RequestMethod.POST)
  public ResponseEntity<?> enviarMensaje(@RequestBody MensajeRequest payload) {
    return mensajeService.crearMensaje(payload);
  }
}
