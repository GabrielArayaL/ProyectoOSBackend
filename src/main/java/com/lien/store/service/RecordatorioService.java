package com.lien.store.service;

import com.lien.store.model.Recordatorio;
import com.lien.store.repository.RecordatorioRepository;
import com.lien.store.repository.UsuarioRepository;
import com.lien.store.request.CrearRecordatorioRequest;
import com.lien.store.request.ModificarRecordatorioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Repository
public class RecordatorioService extends BaseService<Recordatorio, RecordatorioRepository> {
  @Autowired RecordatorioRepository recordatorioRepository;
  @Autowired UsuarioRepository usuarioRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(recordatorioRepository);
  }

  public ResponseEntity<?> crearRecordatorio(CrearRecordatorioRequest payload) {

    try {
      Recordatorio recordatorio = new Recordatorio();
      recordatorio.setId_usuario_recorda(usuarioRepository.findUserById(payload.getId_usuario()));
      recordatorio.setMotivo(payload.getMotivo());

      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      Date fecha = formato.parse(payload.getFecha());
      recordatorio.setFecha(fecha);
      System.out.println("Fecha: " + formato.format(fecha));
      this.save(recordatorio);
      return ResponseEntity.ok("Recordatorio agregado");

    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }

  public List<?> getRecordatorioList(int id) {

    try {
      return recordatorioRepository.findRecordatorioByIdUser(id);

    } catch (Exception e) {
      return null;
    }
  }

  public ResponseEntity<?> modificarRecordatorio(ModificarRecordatorioRequest payload) {

    try {
      Recordatorio recordatorio =
          recordatorioRepository.findRecordatorioById(payload.getId_recordatorio());
      recordatorio.setMotivo(payload.getMotivo());
      SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      Date fecha = formato.parse(payload.getFecha());
      recordatorio.setFecha(fecha);
      System.out.println("Fecha: " + formato.format(fecha));
      this.save(recordatorio);
      return ResponseEntity.ok("Recordatorio modificado");

    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }
}
