package com.pershcorporation.deltacommodityservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminDataValues extends UserData{
    private String region;
    private String marketPrice;
    private String timeStamp;
    @JsonProperty("Region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    @JsonProperty("MarketPrice")
    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }
    @JsonProperty("TimeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
