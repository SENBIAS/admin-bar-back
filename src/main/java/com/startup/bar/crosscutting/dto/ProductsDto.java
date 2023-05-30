package com.startup.bar.crosscutting.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
public class ProductsDto implements Serializable {

    private static final long serialVersionUID = 6135212054548804866L;

    private String licor;
    private List<PresentationDto> presentaciones;
}
