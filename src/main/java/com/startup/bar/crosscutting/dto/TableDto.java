package com.startup.bar.crosscutting.dto;

import com.startup.bar.crosscutting.persistence.entity.ProductsConsumed;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
public class TableDto {
    private ObjectId id;
    private String nameTable;
    private List<ProductsConsumed> productsConsumed;
    private int gain;
    private int price;
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
}
