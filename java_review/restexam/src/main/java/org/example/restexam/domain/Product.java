package org.example.restexam.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter @Setter
@AllArgsConstructor
//@Table(name = "products")
public class Product {
    private Long id;
    private String name;
    private double price;

}
