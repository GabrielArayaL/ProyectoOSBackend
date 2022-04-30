package com.lien.store.repository;

import com.lien.store.model.Recordatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecordatorioRepository extends JpaRepository<Recordatorio, Long> {

  @Query(
      value = "SELECT r.* FROM `os`.recordatorio as r where r.id_recordatorio = (:id)  \n",
      nativeQuery = true)
  Recordatorio findRecordatorioById(@Param("id") int id);

  @Query(
      value = "SELECT r.* FROM `os`.recordatorio as r where r.id_usuario_recorda = (:id)  \n",
      nativeQuery = true)
  List<Recordatorio> findRecordatorioByIdUser(@Param("id") int id);
}
