package com.lien.store;

public final class URLMapping {

  public static final class Usuario {
    public static final String URL = "/usuario";
    public static final String SIGN_UP = "/sign-up";
    public static final String SIGN_IN = "/sign-in/{nombre}/{telefono}";
    public static final String MODIFY = "/modify";
    public static final String GET = "/get/{id}";
  }

  public static final class TipoSala {
    public static final String URL = "/tipo-sala";
  }

  public static final class Sala {
    public static final String URL = "/sala";
    public static final String CREATE = "/create";
    public static final String MODIFY = "/modify";
    public static final String GET = "/get/{id}";
  }

  public static final class SalaUsuario {
    public static final String URL = "/sala-usuario";
  }

  public static final class Recordatorio {
    public static final String URL = "/recordatorio";
    public static final String CREATE = "/create";
    public static final String GET = "/get/{id_user}";
    public static final String MODIFY = "/modify";
  }

  public static final class Contacto {
    public static final String URL = "/contacto";
    public static final String CREATE = "/create";
    public static final String MODIFY = "/modify";
  }

  public static final class TipoMensaje {
    public static final String URL = "/tipo-mensaje";
  }

  public static final class Mensaje {
    public static final String URL = "/mensaje";
    public static final String SENDN = "/send/normal";
    public static final String SENDM = "/send/multimedia";
    public static final String GET = "/get/{id}";
  }
}
