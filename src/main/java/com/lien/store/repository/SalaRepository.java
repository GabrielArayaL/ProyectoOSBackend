package com.lien.store.repository;

import com.lien.store.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

  @Query(value = "SELECT s.* FROM `os`.sala as s where s.id_sala = (:id)  \n", nativeQuery = true)
  Sala findSalaById(@Param("id") int id);
}
