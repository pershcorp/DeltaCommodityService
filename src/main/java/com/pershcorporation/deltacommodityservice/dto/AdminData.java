package com.pershcorporation.deltacommodityservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AdminData{
    private List<AdminDataValues> data;

    @JsonProperty("Data")
    public List<AdminDataValues> getData() {
        return data;
    }

    public void setData(List<AdminDataValues> data) {
        this.data = data;
    }
}
