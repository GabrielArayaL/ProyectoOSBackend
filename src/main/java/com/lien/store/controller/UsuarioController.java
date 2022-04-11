package com.lien.store.controller;

import com.lien.store.URLMapping;
import com.lien.store.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = URLMapping.Usuario.URL)
public class UsuarioController {
  @Autowired UsuarioService usuarioService;
}
