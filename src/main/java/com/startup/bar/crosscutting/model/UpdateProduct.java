package com.startup.bar.crosscutting.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

@Builder
@Getter
@Setter
public class UpdateProduct {
    private ObjectId id;
    @JsonProperty("mm")
    private String mm;

    @JsonProperty("precio_establecimiento")
    private int precioEstablecimiento;

    @JsonProperty("ganancia_establecimiento")
    private int gananciaEstablecimiento;

    @JsonProperty("cantidad")
    private int cantidad;
}
