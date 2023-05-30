package com.startup.bar.crosscutting.persistence.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Presentation {
    @Field("mm")
    @JsonProperty("mm")
    private String mm;

    @Field("precio_establecimiento")
    @JsonProperty("precio_establecimiento")
    private int precioEstablecimiento;

    @Field("ganancia_establecimiento")
    @JsonProperty("ganancia_establecimiento")
    private int gananciaEstablecimiento;

    @Field("cantidad")
    @JsonProperty("cantidad")
    private int cantidad;
}
