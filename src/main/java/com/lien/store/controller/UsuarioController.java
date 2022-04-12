package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.request.SignUpRequest;
import com.lien.store.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URLMapping.Usuario.URL)
public class UsuarioController {
  @Autowired UsuarioService usuarioService;

  @RequestMapping(value = URLMapping.Usuario.SIGN_UP, method = RequestMethod.POST)
  public ResponseEntity<?> crearUsuario(@RequestBody SignUpRequest payload) {
    return usuarioService.crearUsuario(payload);
  }
}
