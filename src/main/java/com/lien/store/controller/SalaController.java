package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.SalaRequest;
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
  public ResponseEntity<?> crearSala(@RequestBody SalaRequest payload) {
    return salaService.crearSala(payload);
  }
}
