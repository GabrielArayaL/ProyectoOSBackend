package com.lien.store.service;

import com.lien.store.model.Contacto;
import com.lien.store.model.Mensaje;
import com.lien.store.model.TipoMensaje;
import com.lien.store.repository.*;
import com.lien.store.request.CrearMensajeRequest;
import com.lien.store.request.ModificarMensajeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
@Repository
public class MensajeService extends BaseService<Mensaje, MensajeRepository> {
  @Autowired MensajeRepository mensajeRepository;
  @Autowired UsuarioRepository usuarioRepository;
  @Autowired SalaRepository salaRepository;
  @Autowired TipoMensajeRepository tipoMensajeRepository;
  @Autowired ContactoRepository contactoRepository;

  @PostConstruct
  public void setVariables() {
    this.setRepository(mensajeRepository);
  }

  public ResponseEntity<?> crearMensajeNormal(CrearMensajeRequest payload, int id_destino) {
    try {
      Contacto contacto1 =
          contactoRepository.findContactoBloqueadoById(payload.getId_usuario(), id_destino);
      Contacto contacto2 =
          contactoRepository.findContactoBloqueadoById(id_destino, payload.getId_usuario());
      if (contacto1 != null && contacto2 != null) {
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
        return ResponseEntity.ok("Mensaje enviado");
      }
      return ResponseEntity.ok("No se pueden enviar mensajes a este chat");

    } catch (Exception e) {
      return ResponseEntity.ok("Error al enviar mensaje");
    }
  }

  public ResponseEntity<?> eliminarMensajeNormal(int id) {
    Mensaje mensaje = mensajeRepository.findMessageById(id);
    mensaje.setTexto("Este Mensaje se ha Eliminado");
    this.save(mensaje);
    return ResponseEntity.ok("Mensaje Eliminado");
  }

  public ResponseEntity<?> modificarMensajeNormal(ModificarMensajeRequest payload) {
    Mensaje mensaje = mensajeRepository.findMessageById(payload.getId_mensaje());
    mensaje.setTexto(payload.getTexto());
    this.save(mensaje);
    return ResponseEntity.ok("Mensaje Modificado");
  }

  public ResponseEntity<?> crearMensajeMultimedia(
      CrearMensajeRequest payload, MultipartFile archivo) {

    try {
      TipoMensaje tipoMensaje = new TipoMensaje();
      tipoMensaje.setNombre(payload.getNombre_msj());

      Mensaje mensaje = new Mensaje();
      mensaje.setId_usuario_msj(usuarioRepository.findUserById(payload.getId_usuario()));
      mensaje.setId_sala_msj(salaRepository.findSalaById(payload.getId_sala()));
      mensaje.setId_tipo_msj(tipoMensaje);
      mensaje.setTexto(payload.getTexto());
      mensaje.setFecha(new Date());
      mensaje.setArchivo(archivo.getBytes());

      this.save(mensaje);
      /*Path directorio = Paths.get("src//main//java//com//lien//store/archivos");
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
      }*/
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
      return mensajeRepository.findMessagesByIdSala(id_sala);
    } catch (Exception e) {
      return null;
    }
  }

  public List<Mensaje> getMensajesFilter(String filter, int id) {

    try {
      return mensajeRepository.findMessageByFilter(filter, id);
    } catch (Exception e) {
      return null;
    }
  }
}
