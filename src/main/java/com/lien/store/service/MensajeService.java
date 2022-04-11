package com.lien.store.service;

import com.lien.store.model.Mensaje;
import com.lien.store.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class MensajeService extends BaseService<Mensaje, MensajeRepository> {
  @Autowired MensajeRepository mensajeRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(mensajeRepository);
  }
}
