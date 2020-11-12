package ningenme.net.api.domain.exception;

public class SelectMysqlException extends RuntimeException {
  public SelectMysqlException(Exception ex) {
    super(ex);
  }
}
