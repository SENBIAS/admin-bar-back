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
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "productos")
public class Product {

    @Id
    @JsonProperty("_id")
    private String id;

    @Field("licor")
    @JsonProperty("licor")
    private String licor;

    @Field("presentaciones")
    @JsonProperty("presentaciones")
    private List<Presentation> presentations;
}
