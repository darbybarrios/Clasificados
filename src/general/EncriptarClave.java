package general;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

/**
 * <p>Title:EncriptarClave </p>
 *
 * <p>Description: Esta clase contiene  los m�todos necesarios para encriptar un texto  </p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company:Enelbar </p>
 *
 * @author not attributable
 * @version 1.0
 */

@SuppressWarnings("restriction")
public final class EncriptarClave {
    /**
      * M�todo que permite encriptar una cadena
      *
      * @param textoplano String
      * @return String (cadena encriptada)
      * @throws GeneralException
      */


  public static String encriptar(String textoplano) throws
      IllegalStateException {
    MessageDigest md = null;

    try {
      md = MessageDigest.getInstance("SHA"); // Instancia de generador SHA-1
    }
    catch (NoSuchAlgorithmException e) {
      throw new IllegalStateException(e.getMessage());
    }

    try {
      md.update(textoplano.getBytes("UTF-8")); // Generaci�n de resumen de mensaje
    }
    catch (UnsupportedEncodingException e) {
      throw new IllegalStateException(e.getMessage());
    }

    byte raw[] = md.digest(); // Obtenci�n del resumen de mensaje
    String hash = (new BASE64Encoder()).encode(raw); // Traducci�n a BASE64
    return hash;
  }
}

