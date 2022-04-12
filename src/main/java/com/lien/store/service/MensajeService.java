package com.lien.store.service;

import com.lien.store.model.Mensaje;
import com.lien.store.model.TipoMensaje;
import com.lien.store.repository.MensajeRepository;
import com.lien.store.repository.SalaRepository;
import com.lien.store.repository.TipoMensajeRepository;
import com.lien.store.repository.UsuarioRepository;
import com.lien.store.request.MensajeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
@Repository
public class MensajeService extends BaseService<Mensaje, MensajeRepository> {
  @Autowired MensajeRepository mensajeRepository;
  @Autowired UsuarioRepository usuarioRepository;
  @Autowired SalaRepository salaRepository;
  @Autowired TipoMensajeRepository tipoMensajeRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(mensajeRepository);
  }

  public ResponseEntity<?> crearMensaje(MensajeRequest payload) {

    try {
      TipoMensaje tipoMensaje = new TipoMensaje();
      tipoMensaje.setNombre(payload.getNombre_mensaje());

      if (payload.getNombre_mensaje().equals("normal")) {

        Mensaje mensaje = new Mensaje();
        mensaje.setId_usuario_msj(usuarioRepository.findUserById(payload.getId_usuario()));
        mensaje.setId_sala_msj(salaRepository.findSalaById(payload.getId_sala()));
        mensaje.setId_tipo_msj(tipoMensaje);
        mensaje.setTexto(payload.getTexto());
        mensaje.setFecha(new Date());

        tipoMensajeRepository.save(tipoMensaje);
        this.save(mensaje);
      } else if (payload.getNombre_mensaje().equals("multimedia") && payload.getTexto() == null) {

        Mensaje mensaje = new Mensaje();
        mensaje.setId_usuario_msj(usuarioRepository.findUserById(payload.getId_usuario()));
        mensaje.setId_sala_msj(salaRepository.findSalaById(payload.getId_sala()));
        mensaje.setId_tipo_msj(tipoMensaje);
        mensaje.setFecha(new Date());
        mensaje.setArchivo(payload.getArchivo());

        tipoMensajeRepository.save(tipoMensaje);
        this.save(mensaje);
      } else {

        Mensaje mensaje = new Mensaje();
        mensaje.setId_usuario_msj(usuarioRepository.findUserById(payload.getId_usuario()));
        mensaje.setId_sala_msj(salaRepository.findSalaById(payload.getId_sala()));
        mensaje.setId_tipo_msj(tipoMensaje);
        mensaje.setTexto(payload.getTexto());
        mensaje.setFecha(new Date());
        mensaje.setArchivo(payload.getArchivo());

        tipoMensajeRepository.save(tipoMensaje);
        this.save(mensaje);
      }
      return ResponseEntity.ok("Mensaje enviado");

    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }
}
