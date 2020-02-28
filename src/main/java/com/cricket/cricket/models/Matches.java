package com.cricket.cricket.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "matches",
        "v",
        "ttl",
        "provider",
        "creditsLeft"
})
public class Matches {

    @JsonProperty("matches")
    private List<MatchMetaInfo> matches = null;
    @JsonProperty("v")
    private String v;


    @Override
    public String toString() {
        return "Matches{" +
                "matches=" + matches +
                ", v='" + v + '\'' +
                ", ttl=" + ttl +
                ", provider=" + provider +
                ", creditsLeft=" + creditsLeft +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    @JsonProperty("ttl")
    private Integer ttl;
    @JsonProperty("provider")
    private Provider provider;
    @JsonProperty("creditsLeft")
    private Integer creditsLeft;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Matches() {
    }

    /**
     *
     * @param creditsLeft
     * @param provider
     * @param v
     * @param matches
     * @param ttl
     */
    public Matches(List<MatchMetaInfo> matches, String v, Integer ttl, Provider provider, Integer creditsLeft) {
        super();
        this.matches = matches;
        this.v = v;
        this.ttl = ttl;
        this.provider = provider;
        this.creditsLeft = creditsLeft;
    }

    @JsonProperty("matches")
    public List<MatchMetaInfo> getMatches() {
        return matches;
    }

    @JsonProperty("matches")
    public void setMatches(List<MatchMetaInfo> matches) {
        this.matches = matches;
    }

    @JsonProperty("v")
    public String getV() {
        return v;
    }

    @JsonProperty("v")
    public void setV(String v) {
        this.v = v;
    }

    @JsonProperty("ttl")
    public Integer getTtl() {
        return ttl;
    }

    @JsonProperty("ttl")
    public void setTtl(Integer ttl) {
        this.ttl = ttl;
    }

    @JsonProperty("provider")
    public Provider getProvider() {
        return provider;
    }

    @JsonProperty("provider")
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @JsonProperty("creditsLeft")
    public Integer getCreditsLeft() {
        return creditsLeft;
    }

    @JsonProperty("creditsLeft")
    public void setCreditsLeft(Integer creditsLeft) {
        this.creditsLeft = creditsLeft;
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
