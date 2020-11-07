package ningenme.net.api.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LogCode {
  /**
   * 独自ログ用コード。responseのステータスにちなんだ番号をつける。
   * http statusに一対一対応するわけではないのでちょっと注意
   * 500番台 Internal Server Error系
   * 400番台 Bad Request系
   * 200番台 正常だけど一応ログ残したいやつ
   */
  API_INFO_501("API_INFO_501","No Handle Error"),
  API_INFO_401("API_INFO_401","Invalid Args Parameter"),
  API_INFO_402("API_INFO_402","No Such Uri"),
  API_INFO_403("API_INFO_403","Invalid Http Method");
  private final String code;
  private final String message;
}
