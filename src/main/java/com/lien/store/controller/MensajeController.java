package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.CrearMensajeRequest;
import com.lien.store.request.ModificarMensajeRequest;
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
  public ResponseEntity<?> enviarMensajeMultimedia(
      @RequestPart("payload") CrearMensajeRequest payload,
      @RequestPart("file") MultipartFile archivo) {
    return mensajeService.crearMensajeMultimedia(payload, archivo);
  }

  @RequestMapping(value = URLMapping.Mensaje.SENDN, method = RequestMethod.POST)
  public ResponseEntity<?> enviarMensajeNormal(
      @RequestBody CrearMensajeRequest payload, @PathVariable int id) {
    return mensajeService.crearMensajeNormal(payload, id);
  }

  @RequestMapping(value = URLMapping.Mensaje.MODIFYN, method = RequestMethod.PUT)
  public ResponseEntity<?> modificarMensajeNormal(@RequestBody ModificarMensajeRequest payload) {
    return mensajeService.modificarMensajeNormal(payload);
  }

  @RequestMapping(value = URLMapping.Mensaje.DELETEN, method = RequestMethod.PUT)
  public ResponseEntity<?> eliminarMensajeNormal(@PathVariable int id) {
    return mensajeService.eliminarMensajeNormal(id);
  }

  @RequestMapping(value = URLMapping.Mensaje.GET, method = RequestMethod.GET)
  public List<?> getMensajes(@PathVariable int id) {
    return mensajeService.getMensaje(id);
  }

  @RequestMapping(value = URLMapping.Mensaje.GETFILTER, method = RequestMethod.GET)
  public List<?> enviarMensaje(@PathVariable String filter, @PathVariable int id) {
    return mensajeService.getMensajesFilter(filter, id);
  }
}
