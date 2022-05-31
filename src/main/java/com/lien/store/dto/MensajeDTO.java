package com.lien.store.dto;

import com.lien.store.model.Mensaje;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.InputStream;

@Getter
@Setter
@Builder
public class MensajeDTO {
  private Mensaje mensaje;
  private BufferedImage image;
  private InputStream audio;
  private InputStream video;
  private MultipartFile archivo;
}
