package com.inditex.manuelMartin.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PriceDTO {


    public PriceDTO() { }

    public PriceDTO(Integer productId, Integer brandId, Double price, Long priceList) {
        this.setBrandId(brandId);
        this.setPriceList(priceList);
        this.setPrice(price);
        this.setProductId(productId);
    }

    @JsonProperty("productId")
    private Integer productId;

    @JsonProperty("brandId")
    private Integer brandId;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("priceList")
    private Long priceList;

}
