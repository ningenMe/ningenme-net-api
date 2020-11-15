package ningenme.net.api.domain.exception;

public class InsertMysqlException extends RuntimeException {
  public InsertMysqlException(Exception ex) {
    super(ex);
  }
}
