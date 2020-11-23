package ningenme.net.api.domain.exception;

public class NoResourceException extends RuntimeException {
  public NoResourceException(Exception ex) {
    super(ex);
  }
}
