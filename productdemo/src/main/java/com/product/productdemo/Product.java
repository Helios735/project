package com.product.productdemo;


import jakarta.persistence.*;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false,length = 50)
    private String name;

    @Column(name = "price", nullable = false,length = 5)
    private Float price;


    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Product(Integer id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
