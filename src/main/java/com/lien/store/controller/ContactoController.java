package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.CrearContactoRequest;
import com.lien.store.request.ModificarContactoRequest;
import com.lien.store.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = URLMapping.Contacto.URL)
public class ContactoController {
  @Autowired ContactoService contactoService;

  @RequestMapping(value = URLMapping.Contacto.CREATE, method = RequestMethod.POST)
  public ResponseEntity<?> crearContacto(@RequestBody CrearContactoRequest payload) {
    return contactoService.crearContacto(payload);
  }

  @RequestMapping(value = URLMapping.Contacto.MODIFY, method = RequestMethod.PUT)
  public ResponseEntity<?> modificarContacto(@RequestBody ModificarContactoRequest payload) {
    return contactoService.modificarContacto(payload);
  }

  @RequestMapping(value = URLMapping.Contacto.LOCK, method = RequestMethod.PUT)
  public ResponseEntity<?> bloquearContacto(
      @PathVariable("id1") int id1, @PathVariable("id2") int id2) {
    return contactoService.bloquearContacto(id1, id2);
  }

  @RequestMapping(value = URLMapping.Contacto.UNLOCK, method = RequestMethod.PUT)
  public ResponseEntity<?> desbloquearContacto(
      @PathVariable("id1") int id1, @PathVariable("id2") int id2) {
    return contactoService.desbloquearContacto(id1, id2);
  }
}
