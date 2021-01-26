package ningenme.net.api.util.domain.exception;

public class SelectMysqlException extends RuntimeException {
  public SelectMysqlException(Exception ex) {
    super(ex);
  }
}
