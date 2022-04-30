package com.lien.store.repository;

import com.lien.store.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

  @Query(value = "SELECT s.* FROM `os`.sala as s where s.id_sala = (:id)  \n", nativeQuery = true)
  Sala findSalaById(@Param("id") int id);

  @Query(
      value =
          "SELECT s.* FROM `os`.sala as s join `os`.sala_usuario as su"
              + " where s.id_sala = su.id_sala_su and su.id_usuario_su = (:id)  \n",
      nativeQuery = true)
  List<Sala> findSalaByIdUser(@Param("id") int id);
}
