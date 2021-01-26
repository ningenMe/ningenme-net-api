package ningenme.net.api.util.domain.exception;

public class InsertMysqlException extends RuntimeException {
  public InsertMysqlException(Exception ex) {
    super(ex);
  }
}
