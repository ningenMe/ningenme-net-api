package ningenme.net.api.util.domain.exception;

public class ClientException extends RuntimeException {
  public ClientException(Exception ex) {
    super(ex);
  }
}
