package br.com.inventory.model.entity;

import io.micronaut.data.annotation.AutoPopulated;
import lombok.Data;


import javax.persistence.*;
import java.util.UUID;

@Data
@Table(name = "tb_product", schema = "public")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @AutoPopulated
    private UUID uuid;

    private String name;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    private Integer quantity;
    private Double price;
    private String description;

}
