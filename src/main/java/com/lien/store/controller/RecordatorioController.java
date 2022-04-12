package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.RecordatorioRequest;
import com.lien.store.service.RecordatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URLMapping.Recordatorio.URL)
public class RecordatorioController {
  @Autowired RecordatorioService recordatorioService;

  @RequestMapping(value = URLMapping.Recordatorio.CREATE, method = RequestMethod.POST)
  public ResponseEntity<?> crearUsuario(@RequestBody RecordatorioRequest payload) {
    return recordatorioService.crearRecordatorio(payload);
  }
}
