package com.lien.store.service;

import com.lien.store.model.Usuario;
import com.lien.store.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
