package ningenme.net.api.compro.domain.exception;

public class ScrapeException extends RuntimeException {
  public ScrapeException(Exception ex) {
    super(ex);
  }
}
