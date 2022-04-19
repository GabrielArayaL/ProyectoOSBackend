package com.lien.store.service;

import com.lien.store.model.Usuario;
import com.lien.store.repository.UsuarioRepository;
import com.lien.store.request.CrearUsuarioRequest;
import com.lien.store.request.ModificarUsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {
  @Autowired UsuarioRepository usuarioRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(usuarioRepository);
  }

  public ResponseEntity<?> crearUsuario(CrearUsuarioRequest payload) {

    try {
      Usuario usuario = new Usuario();
      usuario.setNombre(payload.getNombre());
      usuario.setTelefono(payload.getTelefono());
      this.save(usuario);
      return ResponseEntity.ok("Usuario agregado");

    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }

  public ResponseEntity<?> modificarUsuario(ModificarUsuarioRequest payload) {

    try {
      Usuario usuario = usuarioRepository.findUserById(payload.getId_usuario());
      usuario.setNombre(payload.getNombre());
      usuario.setTelefono(payload.getTelefono());
      this.save(usuario);
      return ResponseEntity.ok("Usuario Modificado");

    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error");
    }
  }
}
