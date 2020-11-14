package ningenme.net.api.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ningenme.net.api.domain.value.Url;

import java.util.Arrays;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum ComproSite {
  /**
   * コンテストのenum
   */
  ATCODER("AtCoder", "https://atcoder.jp"),
  CODEFORCES("Codeforces","https://codeforces.com"),
  YUKICODER("yukicoder","https://yukicoder.me"),
  AOJ("AOJ","http://judge.u-aizu.ac.jp"),
  AOJ_BETA("AOJ","https://onlinejudge.u-aizu.ac.jp"),
  UNKNOWN("Unknown","");

  private final String contestName;
  private final String prefix;

  public static ComproSite getComproSiteByUrl(Url url) {
    String urlString = url.getValue();
    for (ComproSite comproSite: ComproSite.values()) {
      if(comproSite.prefix.length() <= urlString.length() && comproSite.prefix.equals(urlString.substring(0,comproSite.prefix.length()))) {
        return comproSite;
      }
    }
    return UNKNOWN;
  }
}
