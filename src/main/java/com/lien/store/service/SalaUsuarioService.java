package com.lien.store.service;

import com.lien.store.model.SalaUsuario;
import com.lien.store.repository.SalaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class SalaUsuarioService extends BaseService<SalaUsuario, SalaUsuarioRepository> {
  @Autowired SalaUsuarioRepository salaUsuarioRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(salaUsuarioRepository);
  }
}
