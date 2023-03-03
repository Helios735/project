package com.product.productdemo.ProductController;

import com.product.productdemo.Product;
import com.product.productdemo.ProductService.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/listAll")
    public List<Product> showProd(){
        return productService.showProd();
    }

    @PostMapping("/insert")
    public Product insert(@RequestBody Product product){
        return productService.insert(product);
    }


    @GetMapping("/search/{id}")
    public ResponseEntity<Product> search(@PathVariable Integer id){
       try{
        Product product= productService.search(id);
        return new ResponseEntity<Product>(product,HttpStatus.OK);
    }
       catch (NoSuchElementException e){
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id){
        try {
            Product product1 = productService.search(id);
            System.out.println(product1);
            product1.setId(id);
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            productService.insert(product1);

            return new ResponseEntity<>("Your details have been updated succesfully", HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
     try {
         productService.delete(id);
         return new ResponseEntity<>("Deleted Succesfully",HttpStatus.OK);
     }
     catch (NoSuchElementException e){
         return new ResponseEntity<>("Invalid id:Try again",HttpStatus.NOT_FOUND);
     }

    }

}
