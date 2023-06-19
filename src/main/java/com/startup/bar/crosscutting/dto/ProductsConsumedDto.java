package com.startup.bar.crosscutting.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ProductsConsumedDto {
    private String name;
    private int price;
    private int gain;
}
