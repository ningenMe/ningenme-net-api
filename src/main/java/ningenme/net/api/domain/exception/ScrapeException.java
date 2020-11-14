package ningenme.net.api.domain.exception;

public class ScrapeException extends RuntimeException {
  public ScrapeException(Exception ex) {
    super(ex);
  }
}
