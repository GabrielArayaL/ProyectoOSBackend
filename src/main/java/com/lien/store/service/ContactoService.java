package com.lien.store.service;

import com.lien.store.model.Contacto;
import com.lien.store.repository.ContactoRepository;
import com.lien.store.repository.UsuarioRepository;
import com.lien.store.request.CrearContactoRequest;
import com.lien.store.request.ModificarContactoRequest;
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

  public ResponseEntity<?> crearContacto(CrearContactoRequest payload) {

    try {
      Contacto contacto = new Contacto();
      contacto.setId_usuario1_contact(usuarioRepository.findUserById(payload.getId_usuario()));
      contacto.setId_usuario2_contact(usuarioRepository.findUserByCellphone(payload.getNumero()));
      contacto.setNombre_contacto(payload.getNombre_contacto());
      contacto.setNumero_contacto(payload.getNumero());
      this.save(contacto);
      return ResponseEntity.ok("Contacto agregado");

    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }

  public ResponseEntity<?> modificarContacto(ModificarContactoRequest payload) {

    try {
      Contacto contacto = contactoRepository.findContactoById(payload.getId_contacto());
      contacto.setNombre_contacto(payload.getNombre_contacto());
      contacto.setNumero_contacto(payload.getNumero_contacto());
      this.save(contacto);
      return ResponseEntity.ok("Contacto modificado");

    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }
}
