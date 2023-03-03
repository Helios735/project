package com.product.productdemo.ProductService;

import com.product.productdemo.Product;
import com.product.productdemo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public List<Product> showProd(){
        return productRepository.findAll();
    }


    public Product insert(Product product){
        return productRepository.save(product);
    }

    public Product search(Integer id){
        return productRepository.findById(id).get();
    }

    public void delete(Integer id){
        productRepository.deleteById(id);
    }
}
