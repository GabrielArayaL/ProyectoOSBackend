package com.lien.store.repository;

import com.lien.store.model.SalaUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaUsuarioRepository extends JpaRepository<SalaUsuario, Long> {}
