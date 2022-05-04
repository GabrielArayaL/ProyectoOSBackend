package com.lien.store.service;

import com.lien.store.model.Mensaje;
import com.lien.store.model.TipoMensaje;
import com.lien.store.repository.MensajeRepository;
import com.lien.store.repository.SalaRepository;
import com.lien.store.repository.TipoMensajeRepository;
import com.lien.store.repository.UsuarioRepository;
import com.lien.store.request.MensajeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Repository
public class MensajeService extends BaseService<Mensaje, MensajeRepository> {
  @Autowired MensajeRepository mensajeRepository;
  @Autowired UsuarioRepository usuarioRepository;
  @Autowired SalaRepository salaRepository;
  @Autowired TipoMensajeRepository tipoMensajeRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(mensajeRepository);
  }

  public ResponseEntity<?> crearMensajeNormal(MensajeRequest payload) {
    try {
      TipoMensaje tipoMensaje = new TipoMensaje();
      tipoMensaje.setNombre(payload.getNombre_msj());
      Mensaje mensaje = new Mensaje();
      mensaje.setId_usuario_msj(usuarioRepository.findUserById(payload.getId_usuario()));
      mensaje.setId_sala_msj(salaRepository.findSalaById(payload.getId_sala()));
      mensaje.setId_tipo_msj(tipoMensaje);
      mensaje.setTexto(payload.getTexto());
      mensaje.setFecha(new Date());
      mensaje.setArchivo(null);

      tipoMensajeRepository.save(tipoMensaje);
      this.save(mensaje);
    } catch (Exception e) {
      return ResponseEntity.ok("Mensaje enviado");
    }
    return ResponseEntity.ok("Mensaje enviado");
  }

  public ResponseEntity<?> crearMensajeMultimedia(MensajeRequest payload, MultipartFile imagen) {

    try {
      TipoMensaje tipoMensaje = new TipoMensaje();
      tipoMensaje.setNombre(payload.getNombre_msj());

      Mensaje mensaje = new Mensaje();
      mensaje.setId_usuario_msj(usuarioRepository.findUserById(payload.getId_usuario()));
      mensaje.setId_sala_msj(salaRepository.findSalaById(payload.getId_sala()));
      mensaje.setId_tipo_msj(tipoMensaje);
      mensaje.setTexto(payload.getTexto());
      mensaje.setFecha(new Date());
      mensaje.setArchivo(Objects.requireNonNull(imagen.getOriginalFilename()));

      Path directorio = Paths.get("src//main//java//com//lien//store/archivos");
      String rutaAbsoulta = directorio.toFile().getAbsolutePath();

      File carpeta = new File(rutaAbsoulta);
      File[] archivos = carpeta.listFiles();
      assert archivos != null;
      for (File file : archivos) {
        if (!file.getName().equals(imagen.getOriginalFilename())) {
          byte[] archivo = imagen.getBytes();
          Path guardarArchivo = Paths.get(rutaAbsoulta + "//" + imagen.getOriginalFilename());
          Files.write(guardarArchivo, archivo);
          tipoMensajeRepository.save(tipoMensaje);
          this.save(mensaje);

          return ResponseEntity.ok("Mensaje enviado");
        }
      }
      tipoMensajeRepository.save(tipoMensaje);
      this.save(mensaje);
      return ResponseEntity.ok("Mensaje enviado");

    } catch (Exception e) {
      System.out.println("ERROR: " + e.toString());
      return ResponseEntity.badRequest().body("Error");
    }
  }

  public List<Mensaje> getMensaje(int id_sala) {

    try {
      return mensajeRepository.findSalaByIdSala(id_sala);
    } catch (Exception e) {
      return null;
    }
  }
}
