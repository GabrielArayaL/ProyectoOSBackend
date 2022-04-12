package com.lien.store.service;

import com.lien.store.model.Sala;
import com.lien.store.model.SalaUsuario;
import com.lien.store.model.TipoSala;
import com.lien.store.repository.SalaRepository;
import com.lien.store.repository.UsuarioRepository;
import com.lien.store.request.SalaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class SalaService extends BaseService<Sala, SalaRepository> {
  @Autowired SalaRepository salaRepository;
  @Autowired SalaUsuarioService salaUsuarioService;
  @Autowired TipoSalaService tipoSalaService;
  @Autowired UsuarioRepository usuarioRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(salaRepository);
  }

  public ResponseEntity<?> crearSala(SalaRequest payload) {

    try {
      if (payload.getNombre_tipo_sala().equals("chat")) {

        TipoSala tipoSala = new TipoSala();
        tipoSala.setNombre(payload.getNombre_tipo_sala());

        Sala sala = new Sala();
        sala.setId_tipo_sala_ts(tipoSala);
        sala.setNombre(payload.getNombre_sala());
        sala.setFecha(payload.getFecha());

        SalaUsuario salaUsuario = new SalaUsuario();
        salaUsuario.setId_sala_su(sala);
        salaUsuario.setId_usuario_su(usuarioRepository.findUserById(payload.getId_usuario()));
        tipoSalaService.save(tipoSala);
        this.save(sala);
        salaUsuarioService.save(salaUsuario);
        return ResponseEntity.ok("Chat creado");
      } else {
        TipoSala tipoSala = new TipoSala();
        tipoSala.setNombre(payload.getNombre_tipo_sala());

        Sala sala = new Sala();
        sala.setId_tipo_sala_ts(tipoSala);
        sala.setNombre(payload.getNombre_sala());
        sala.setNombre(payload.getNombre_sala());
        sala.setFecha(payload.getFecha());

        SalaUsuario salaUsuario = new SalaUsuario();
        salaUsuario.setId_sala_su(sala);
        salaUsuario.setId_usuario_su(usuarioRepository.findUserById(payload.getId_usuario()));
        tipoSalaService.save(tipoSala);
        this.save(sala);
        salaUsuarioService.save(salaUsuario);
        return ResponseEntity.ok("Grupo Creado");
      }

    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }
}
