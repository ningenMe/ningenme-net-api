package ningenme.net.api.domain.exception;

public class ClientException extends RuntimeException {
  public ClientException(Exception ex) {
    super(ex);
  }
}
