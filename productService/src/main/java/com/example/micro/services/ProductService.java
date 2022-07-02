package com.example.micro.services;

import com.example.micro.entity.Product;
import com.example.micro.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    //Create
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    //Read
    public ArrayList<Product> getProducts() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    //Remove
    public boolean deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //Update
    public Product updateProduct(Long id, Product product) {
        try {
            productRepository.deleteById(id);
            return productRepository.save(product);
        } catch (Exception e) {
            return null;
        }

    }


}
