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
  List<Mensaje> findMessagesByIdSala(@Param("id") int id);

  @Query(
      value = "SELECT m.* FROM `os`.mensaje as m where m.id_mensaje = (:id)  \n",
      nativeQuery = true)
  Mensaje findMessageById(@Param("id") int id);

  @Query(
      value =
          "SELECT m.* FROM `os`.mensaje as m where (m.id_sala_msj = (:id)  AND m.texto LIKE CONCAT('%',:filter,'%')  or m.fecha LIKE CONCAT('%',:filter,'%') )",
      nativeQuery = true)
  List<Mensaje> findMessageByFilter(@Param("filter") String filter, @Param("id") int id);
}
