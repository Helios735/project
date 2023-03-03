package com.product.productdemo.repo;

import com.product.productdemo.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
