package ningenme.net.api.infrastructure.client.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ningenme.net.api.domain.exception.ClientException;
import ningenme.net.api.infrastructure.client.dto.AtcoderUserHistoryClientDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class AtcoderUserHistoryClientMapper {
  private final static String HISTORY_URL = "https://atcoder.jp/users/%s/history/json";

  public List<AtcoderUserHistoryClientDto> get(String atcoderId) {
    String url = String.format(HISTORY_URL,atcoderId);
    Request request = new Request.Builder()
            .url(url)
            .build();
    OkHttpClient okHttpClient = new OkHttpClient();
    try (Response response = okHttpClient.newCall(request).execute()) {
      String json = response.body().string();
      Gson gson = new Gson();
      Type type = new TypeToken<List<AtcoderUserHistoryClientDto>>(){}.getType();
      return gson.fromJson(json, type);
    }
    catch (Exception ex) {
      throw new ClientException(ex);
    }
  }
}
