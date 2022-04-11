package com.lien.store.service;

import com.lien.store.model.TipoSala;
import com.lien.store.repository.TipoSalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class TipoSalaService extends BaseService<TipoSala, TipoSalaRepository> {
  @Autowired TipoSalaRepository tipoSalaRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(tipoSalaRepository);
  }
}
