package com.example.micro.controller;

import com.example.micro.entity.Product;
import com.example.micro.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping()
    public Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping()
    public ArrayList<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }


}
