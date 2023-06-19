package com.startup.bar.crosscutting.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail implements Serializable {
    private String licor;
    private String mm;
    private Integer price;
    private Integer gain;
}
