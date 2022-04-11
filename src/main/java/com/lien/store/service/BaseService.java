package com.lien.store.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Repository
@Service
public abstract class BaseService<E, R extends JpaRepository<E, Long>> {
  R repostiory;

  @PostConstruct
  public abstract void setVariables();

  public void setRepository(R repository) {
    this.repostiory = repository;
  }

  public E save(E entity) {
    return repostiory.save(entity);
  }

  public Optional<E> findById(Long id) {
    return repostiory.findById(id);
  }

  public List<E> findAll() {
    return repostiory.findAll();
  }

  public Long count() {
    return repostiory.count();
  }

  public void deleteById(Long id) {
    repostiory.deleteById(id);
  }

  public void deleteAll() {
    repostiory.deleteAll();
  }
}
