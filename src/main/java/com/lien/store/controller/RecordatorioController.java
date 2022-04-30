package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.CrearRecordatorioRequest;
import com.lien.store.request.ModificarRecordatorioRequest;
import com.lien.store.service.RecordatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = URLMapping.Recordatorio.URL)
public class RecordatorioController {
  @Autowired RecordatorioService recordatorioService;

  @RequestMapping(value = URLMapping.Recordatorio.CREATE, method = RequestMethod.POST)
  public ResponseEntity<?> crearRecordatorio(@RequestBody CrearRecordatorioRequest payload) {
    return recordatorioService.crearRecordatorio(payload);
  }

  @RequestMapping(value = URLMapping.Recordatorio.GET, method = RequestMethod.GET)
  public List<?> getRecordatorioList(@PathVariable int id_user) {
    return recordatorioService.getRecordatorioList(id_user);
  }

  @RequestMapping(value = URLMapping.Recordatorio.MODIFY, method = RequestMethod.PUT)
  public ResponseEntity<?> modificarUsuario(@RequestBody ModificarRecordatorioRequest payload) {
    return recordatorioService.modificarRecordatorio(payload);
  }
}
