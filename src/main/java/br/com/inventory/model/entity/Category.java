package br.com.inventory.model.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Table(name = "tb_category",schema = "public")
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

}
