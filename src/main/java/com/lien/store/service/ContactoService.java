package com.lien.store.service;

import com.lien.store.model.Contacto;
import com.lien.store.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Repository
public class ContactoService extends BaseService<Contacto, ContactoRepository> {

  @Autowired ContactoRepository contactoRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(contactoRepository);
  }
}
