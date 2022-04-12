package com.lien.store.service;

import com.lien.store.model.Contacto;
import com.lien.store.repository.ContactoRepository;
import com.lien.store.repository.UsuarioRepository;
import com.lien.store.request.ContactoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class ContactoService extends BaseService<Contacto, ContactoRepository> {

  @Autowired ContactoRepository contactoRepository;
  @Autowired UsuarioRepository usuarioRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(contactoRepository);
  }

  public ResponseEntity<?> crearContacto(ContactoRequest payload) {

    try {
      Contacto contacto = new Contacto();
      contacto.setId_usuario1_contact(usuarioRepository.findUserById(payload.getId_usuario()));
      contacto.setId_usuario2_contact(
          usuarioRepository.findUserByCellphone(payload.getId_usuario()));
      this.save(contacto);
      return ResponseEntity.ok("Contacto agregado");

    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }
}
