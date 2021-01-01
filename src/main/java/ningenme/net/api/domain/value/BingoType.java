package ningenme.net.api.domain.value;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BingoType {

  ALL("all"),
  ABC("abc"),
  ARC("arc"),
  AGC("agc"),
  UNKNOWN("UNKNOWN");
  private final String value;

  public static BingoType of(String value) {
    for(BingoType bingoType: BingoType.values()) {
      if(bingoType.value.equals(value)) {
        return bingoType;
      }
    }
    return BingoType.UNKNOWN;
  }

  public Boolean isOwnType(ContestId contestId) {
    if(this.equals(BingoType.UNKNOWN)) {
      return false;
    }
    if(this.equals(BingoType.ALL)) {
      return true;
    }
    if(contestId.getValue().startsWith(this.value)) {
      return true;
    }
    return false;
  }
}
