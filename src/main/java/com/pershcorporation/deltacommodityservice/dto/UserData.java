package com.pershcorporation.deltacommodityservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserData {
    private String sellerName;
    private String quantity;
    private String buyingPrice;
    private String purity;

    public String getSellerName() {
        return sellerName;
    }
    @JsonProperty("SellerName")
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getQuantity() {
        return quantity;
    }
    @JsonProperty("Quantity")
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBuyingPrice() {
        return buyingPrice;
    }
    @JsonProperty("BuyingPrice")
    public void setBuyingPrice(String buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public String getPurity() {
        return purity;
    }
    @JsonProperty("Purity")
    public void setPurity(String purity) {
        this.purity = purity;
    }
}
