package com.lien.store.service;

import com.lien.store.model.Segurity;
import com.lien.store.model.Usuario;
import com.lien.store.repository.SegurityRepository;
import com.lien.store.repository.UsuarioRepository;
import com.lien.store.request.CrearUsuarioRequest;
import com.lien.store.request.ModificarUsuarioRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Repository
public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {
  @Autowired UsuarioRepository usuarioRepository;
  @Autowired SegurityRepository segurityRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(usuarioRepository);
  }

  public ResponseEntity<?> crearUsuario(CrearUsuarioRequest payload) {

    try {

      Usuario usuario = new Usuario();
      usuario.setNombre(payload.getNombre());
      usuario.setTelefono(payload.getTelefono());

      Segurity segurity = new Segurity();
      segurity.setId_usuario_seg(usuario);
      segurity.setPassword(payload.getPassword());

      segurityRepository.save(segurity);
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

  public Usuario getUsuario(String nombre, String password) {

    try {
      return usuarioRepository.findUserByNameAndPass(nombre, password);
    } catch (Exception e) {
      return null;
    }
  }

  /*public List<UsuarioDTO> getContactoDTOList(List<Usuario> usuarioList) {

    List<UsuarioDTO> contactoDTOS = new ArrayList<>();

    usuarioList.forEach(organization -> contactoDTOS.add(getCotactoDTO(organization)));

    return contactoDTOS;
  }*/

  public List<Usuario> getCotactoDTO(Usuario usuario) {

    // List<Usuario> usuarios = usuarioRepository.findContacts(usuario.getId_usuario());

    // return UsuarioDTO.builder().usuario(usuarios).build();

    return usuarioRepository.findContacts(usuario.getId_usuario());
  }
}
