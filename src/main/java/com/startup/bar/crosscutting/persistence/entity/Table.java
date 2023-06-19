package com.startup.bar.crosscutting.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "mesas")
public class Table {
    @Id
    @JsonProperty("_id")
    private String id;

    @Field("nameTable")
    @JsonProperty("name_table")
    private String nameTable;

    @Field("productsConsumed")
    @JsonProperty("products_consumed")
    private List<ProductsConsumed> productsConsumed;

    @Field("precio_establecimiento")
    @JsonProperty("precio_establecimiento")
    private Integer price;

    @Field("ganancia_establecimiento")
    @JsonProperty("ganancia_establecimiento")
    private Integer gain;

    @Field("fechaEntrada")
    @JsonProperty("fecha_entrada")
    private LocalDateTime fechaEntrada;

    @Field("fechaSalida")
    @JsonProperty("fecha_salida")
    private LocalDateTime fechaSalida;
}
