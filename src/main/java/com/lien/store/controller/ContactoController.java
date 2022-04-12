package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.ContactoRequest;
import com.lien.store.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URLMapping.Contacto.URL)
public class ContactoController {
  @Autowired ContactoService contactoService;

  @RequestMapping(value = URLMapping.Contacto.CREATE, method = RequestMethod.POST)
  public ResponseEntity<?> crearUsuario(@RequestBody ContactoRequest payload) {
    return contactoService.crearContacto(payload);
  }
}
