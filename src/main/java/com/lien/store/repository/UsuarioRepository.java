package com.lien.store.repository;

import com.lien.store.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  @Query(
      value = "SELECT u.* FROM `os`.usuario as u where u.id_usuario = (:id)  \n",
      nativeQuery = true)
  Usuario findUserById(@Param("id") int id);

  @Query(
      value = "SELECT u.* FROM `os`.usuario as u where u.telefono = (:telefono)  \n",
      nativeQuery = true)
  Usuario findUserByCellphone(@Param("telefono") int telefono);

  @Query(
      value =
          "SELECT u.* FROM `os`.usuario as u join `os`.contacto as c where u.id_usuario = c.id_usuario2_contac "
              + " and c.id_usuario1_contac = (:id) \n",
      nativeQuery = true)
  List<Usuario> findContacts(@Param("id") int id);

  @Query(
      value =
          "SELECT u.* FROM `os`.usuario as u join `os`.segurity as s where "
              + " u.id_usuario = s.id_usuario_seg and u.nombre = (:nombre) "
              + " and s.password = (:password) \n",
      nativeQuery = true)
  Usuario findUserByNameAndPass(@Param("nombre") String nombre, @Param("password") String password);
}
