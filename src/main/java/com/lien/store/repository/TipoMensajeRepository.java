package com.lien.store.repository;

import com.lien.store.model.TipoMensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoMensajeRepository extends JpaRepository<TipoMensaje, Long> {}
