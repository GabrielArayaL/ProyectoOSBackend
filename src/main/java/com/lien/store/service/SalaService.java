package com.lien.store.service;

import com.lien.store.model.Sala;
import com.lien.store.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class SalaService extends BaseService<Sala, SalaRepository> {
  @Autowired SalaRepository salaRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(salaRepository);
  }
}
