package ningenme.net.api.compro.infrastructure.atcoder.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class AtcoderUserHistoryAtcoderDto {
  @SerializedName("IsRated")
  Boolean isRated;
  @SerializedName("Place")
  Integer place;
  @SerializedName("OldRating")
  Integer oldRating;
  @SerializedName("NewRating")
  Integer newRating;
  @SerializedName("Performance")
  Integer performance;
  @SerializedName("InnerPerformance")
  Integer innerPerformance;
  @SerializedName("ContestScreenName")
  String contestScreenName;
  @SerializedName("ContestName")
  String contestName;
  @SerializedName("ContestNameEn")
  String contestNameEn;
  @SerializedName("EndTime")
  Timestamp endTime;
}
