package ningenme.net.api.domain.repository;

public interface BatchMysqlRepository {
  public void put(String name, String info);
  public String get(String name);
}
