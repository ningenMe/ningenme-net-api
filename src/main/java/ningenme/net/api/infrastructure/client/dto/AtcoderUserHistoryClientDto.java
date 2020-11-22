package ningenme.net.api.infrastructure.client.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class AtcoderUserHistoryClientDto {
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
