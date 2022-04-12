package com.lien.store.service;

import com.lien.store.model.Recordatorio;
import com.lien.store.repository.RecordatorioRepository;
import com.lien.store.repository.UsuarioRepository;
import com.lien.store.request.RecordatorioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class RecordatorioService extends BaseService<Recordatorio, RecordatorioRepository> {
  @Autowired RecordatorioRepository recordatorioRepository;
  @Autowired UsuarioRepository usuarioRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(recordatorioRepository);
  }

  public ResponseEntity<?> crearRecordatorio(RecordatorioRequest payload) {

    try {
      Recordatorio recordatorio = new Recordatorio();
      recordatorio.setId_usuario_recorda(usuarioRepository.findUserById(payload.getId_usuario()));
      recordatorio.setMotivo(payload.getMotivo());
      recordatorio.setFecha(payload.getFecha());
      this.save(recordatorio);
      return ResponseEntity.ok("Recordatorio agregado");

    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }
}
