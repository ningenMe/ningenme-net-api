package ningenme.net.api.compro.infrastructure.atcoder.mapper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ningenme.net.api.compro.domain.exception.ClientException;
import ningenme.net.api.compro.infrastructure.atcoder.dto.AtcoderUserHistoryAtcoderDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;

@Component
public class AtcoderUserHistoryAtcoderMapper {
  private final static String HISTORY_URL = "https://atcoder.jp/users/%s/history/json";

  public List<AtcoderUserHistoryAtcoderDto> get(String atcoderId) {
    String url = String.format(HISTORY_URL,atcoderId);
    Request request = new Request.Builder()
            .url(url)
            .build();
    OkHttpClient okHttpClient = new OkHttpClient();
    try (Response response = okHttpClient.newCall(request).execute()) {
      String json = response.body().string();
      Gson gson = new Gson();
      Type type = new TypeToken<List<AtcoderUserHistoryAtcoderDto>>(){}.getType();
      return gson.fromJson(json, type);
    }
    catch (Exception ex) {
      throw new ClientException(ex);
    }
  }
}
