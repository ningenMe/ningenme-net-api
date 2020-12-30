package ningenme.net.api.domain.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

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

  private final String siteId;
  private final String prefix;

  public static ComproSite of(Url url) {
    String urlString = url.getValue();
    for (ComproSite comproSite: ComproSite.values()) {
      if(comproSite.prefix.length() <= urlString.length() && comproSite.prefix.equals(urlString.substring(0,comproSite.prefix.length()))) {
        return comproSite;
      }
    }
    return UNKNOWN;
  }

  public static ComproSite of(String site) {
    for (ComproSite comproSite: ComproSite.values()) {
      if(comproSite.siteId.equals(site)) {
        return comproSite;
      }
    }
    return UNKNOWN;
  }
}
