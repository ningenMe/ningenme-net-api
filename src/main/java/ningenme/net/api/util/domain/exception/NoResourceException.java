package ningenme.net.api.util.domain.exception;

public class NoResourceException extends RuntimeException {
  public NoResourceException(Exception ex) {
    super(ex);
  }
}
