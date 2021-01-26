package ningenme.net.api.util.domain.exception;

public class ScrapeException extends RuntimeException {
  public ScrapeException(Exception ex) {
    super(ex);
  }
}
