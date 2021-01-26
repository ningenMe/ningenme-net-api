package ningenme.net.api.compro.domain.exception;

public class ClientException extends RuntimeException {
  public ClientException(Exception ex) {
    super(ex);
  }
}
