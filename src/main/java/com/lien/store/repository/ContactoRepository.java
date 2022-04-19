package com.lien.store.repository;

import com.lien.store.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Long> {

  @Query(
      value = "SELECT c.* FROM `os`.contacto as c \n" + " where c.id_contacto = (:id) \n",
      nativeQuery = true)
  Contacto findContactoById(@Param("id") int id);
}
