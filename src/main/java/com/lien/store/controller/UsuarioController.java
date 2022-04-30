package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.model.Usuario;
import com.lien.store.repository.UsuarioRepository;
import com.lien.store.request.CrearUsuarioRequest;
import com.lien.store.request.ModificarUsuarioRequest;
import com.lien.store.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = URLMapping.Usuario.URL)
public class UsuarioController {
  @Autowired UsuarioService usuarioService;
  @Autowired UsuarioRepository usuarioRepository;

  @RequestMapping(value = URLMapping.Usuario.SIGN_UP, method = RequestMethod.POST)
  public ResponseEntity<?> crearUsuario(@RequestBody CrearUsuarioRequest payload) {
    return usuarioService.crearUsuario(payload);
  }

  @RequestMapping(value = URLMapping.Usuario.SIGN_IN, method = RequestMethod.GET)
  public Usuario crearUsuario(@PathVariable String nombre, @PathVariable int telefono) {
    return usuarioService.getUsuario(nombre, telefono);
  }

  @RequestMapping(value = URLMapping.Usuario.MODIFY, method = RequestMethod.PUT)
  public ResponseEntity<?> modificarUsuario(@RequestBody ModificarUsuarioRequest payload) {
    return usuarioService.modificarUsuario(payload);
  }

  @RequestMapping(value = URLMapping.Usuario.GET, method = RequestMethod.GET)
  public List<?> getContacto(@PathVariable int id) {
    return usuarioService.getCotactoDTO(usuarioRepository.findUserById(id));
  }
}
