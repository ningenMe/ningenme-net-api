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
  API_INFO_502("API_INFO_502","Insert Compro Category User Error"),
  API_INFO_503("API_INFO_503","Select Mysql Error"),
  API_INFO_401("API_INFO_401","Invalid Args Parameter"),
  API_INFO_402("API_INFO_402","No Such Uri"),
  API_INFO_403("API_INFO_403","Invalid Http Method"),
  API_INFO_404("API_INFO_404","Some Request Parameter Are Not Present"),
  API_INFO_405("API_INFO_405","Authenticaiton Failed"),
  API_INFO_406("API_INFO_406","Url Dupulicated"),
  API_INFO_201("API_INFO_201","New Compro Category User Was Created"),
  API_INFO_202("API_INFO_202","OK"),
  API_INFO_203("API_INFO_203","Login OK"),
  API_INFO_204("API_INFO_204","No ComproCategoryGenre Cached"),
  API_INFO_205("API_INFO_205","No ComproCategoryTopic Cached"),
  API_INFO_206("API_INFO_206","Failed Insert Relation Between Topic And Task");
  private final String code;
  private final String message;
}
