package com.lien.store.service;

import com.lien.store.model.Recordatorio;
import com.lien.store.repository.RecordatorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class RecordatorioService extends BaseService<Recordatorio, RecordatorioRepository> {
  @Autowired RecordatorioRepository recordatorioRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(recordatorioRepository);
  }
}
