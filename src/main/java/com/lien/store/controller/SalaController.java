package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.CrearSalaRequest;
import com.lien.store.request.ModificarSalaRequest;
import com.lien.store.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URLMapping.Sala.URL)
public class SalaController {
  @Autowired SalaService salaService;

  @RequestMapping(value = URLMapping.Sala.CREATE, method = RequestMethod.POST)
  public ResponseEntity<?> crearSala(@RequestBody CrearSalaRequest payload) {
    return salaService.crearSala(payload);
  }

  @RequestMapping(value = URLMapping.Sala.MODIFY, method = RequestMethod.PUT)
  public ResponseEntity<?> modificarSala(@RequestBody ModificarSalaRequest payload) {
    return salaService.modificarGrupo(payload);
  }
}
