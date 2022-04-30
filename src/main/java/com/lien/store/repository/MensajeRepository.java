package com.lien.store.repository;

import com.lien.store.model.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

  @Query(
      value = "SELECT m.* FROM `os`.mensaje as m where m.id_sala_msj = (:id)  \n",
      nativeQuery = true)
  List<Mensaje> findSalaByIdSala(@Param("id") int id);
}
