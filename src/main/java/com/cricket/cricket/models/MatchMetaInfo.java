
package com.cricket.cricket.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "unique_id",
        "date",
        "dateTimeGMT",
        "team-1",
        "team-2",
        "type",
        "squad",
        "toss_winner_team",
        "winner_team",
        "matchStarted"
})
public class MatchMetaInfo {

    @JsonProperty("unique_id")
    private Integer uniqueId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("dateTimeGMT")
    private String dateTimeGMT;
    @JsonProperty("team-1")
    private String team1;
    @JsonProperty("team-2")
    private String team2;
    @JsonProperty("type")
    private String type;
    @JsonProperty("squad")
    private Boolean squad;
    @JsonProperty("toss_winner_team")
    private String tossWinnerTeam;
    @JsonProperty("winner_team")
    private String winnerTeam;
    @JsonProperty("matchStarted")
    private Boolean matchStarted;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public MatchMetaInfo() {
    }

    @Override
    public String toString() {
        return "MatchMetaInfo{" +
                "uniqueId=" + uniqueId +
                ", date='" + date + '\'' +
                ", dateTimeGMT='" + dateTimeGMT + '\'' +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", type='" + type + '\'' +
                ", squad=" + squad +
                ", tossWinnerTeam='" + tossWinnerTeam + '\'' +
                ", winnerTeam='" + winnerTeam + '\'' +
                ", matchStarted=" + matchStarted +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    /**
     *
     * @param date
     * @param tossWinnerTeam
     * @param squad
     * @param team1
     * @param team2
     * @param winnerTeam
     * @param dateTimeGMT
     * @param matchStarted
     * @param type
     * @param uniqueId
     */
    public MatchMetaInfo(Integer uniqueId, String date, String dateTimeGMT, String team1, String team2, String type, Boolean squad, String tossWinnerTeam, String winnerTeam, Boolean matchStarted) {
        super();
        this.uniqueId = uniqueId;
        this.date = date;
        this.dateTimeGMT = dateTimeGMT;
        this.team1 = team1;
        this.team2 = team2;
        this.type = type;
        this.squad = squad;
        this.tossWinnerTeam = tossWinnerTeam;
        this.winnerTeam = winnerTeam;
        this.matchStarted = matchStarted;
    }

    @JsonProperty("unique_id")
    public Integer getUniqueId() {
        return uniqueId;
    }

    @JsonProperty("unique_id")
    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("dateTimeGMT")
    public String getDateTimeGMT() {
        return dateTimeGMT;
    }

    @JsonProperty("dateTimeGMT")
    public void setDateTimeGMT(String dateTimeGMT) {
        this.dateTimeGMT = dateTimeGMT;
    }

    @JsonProperty("team-1")
    public String getTeam1() {
        return team1;
    }

    @JsonProperty("team-1")
    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    @JsonProperty("team-2")
    public String getTeam2() {
        return team2;
    }

    @JsonProperty("team-2")
    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("squad")
    public Boolean getSquad() {
        return squad;
    }

    @JsonProperty("squad")
    public void setSquad(Boolean squad) {
        this.squad = squad;
    }

    @JsonProperty("toss_winner_team")
    public String getTossWinnerTeam() {
        return tossWinnerTeam;
    }

    @JsonProperty("toss_winner_team")
    public void setTossWinnerTeam(String tossWinnerTeam) {
        this.tossWinnerTeam = tossWinnerTeam;
    }

    @JsonProperty("winner_team")
    public String getWinnerTeam() {
        return winnerTeam;
    }

    @JsonProperty("winner_team")
    public void setWinnerTeam(String winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    @JsonProperty("matchStarted")
    public Boolean getMatchStarted() {
        return matchStarted;
    }

    @JsonProperty("matchStarted")
    public void setMatchStarted(Boolean matchStarted) {
        this.matchStarted = matchStarted;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
