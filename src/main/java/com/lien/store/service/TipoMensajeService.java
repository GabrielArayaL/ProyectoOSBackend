package com.lien.store.service;

import com.lien.store.model.TipoMensaje;
import com.lien.store.repository.TipoMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class TipoMensajeService extends BaseService<TipoMensaje, TipoMensajeRepository> {
  @Autowired TipoMensajeRepository tipoMensajeRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(tipoMensajeRepository);
  }
}
