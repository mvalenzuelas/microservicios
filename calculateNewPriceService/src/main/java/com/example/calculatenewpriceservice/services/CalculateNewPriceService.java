package com.example.calculatenewpriceservice.services;

import com.example.calculatenewpriceservice.entity.Exchange;
import com.example.calculatenewpriceservice.model.Product;
import com.example.calculatenewpriceservice.repository.ExchangeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class CalculateNewPriceService {

    @Autowired
    ExchangeRepository exchangeRepository;
    @Autowired
    RestTemplate restTemplate;

    public Optional<Exchange> getExchangeById(Long id){
        return exchangeRepository.findById(id);
    }

    public List<Product> getProducts(){
        return  restTemplate.getForObject("http://localhost:8001/product",List.class);
    }

    public List<Product> calculateNewPriceByDollars(){
        float dollarExchangeRate=getExchangeById(1L).get().getExchangeRate();
        ObjectMapper mapper = new ObjectMapper();
        List<Product> products = mapper.convertValue(getProducts(), new TypeReference<List<Product>>() { });

        List<Product> newProducts= new ArrayList<>();
        for (Product product:products) {
            Product productToAdd= new Product();
            productToAdd.setId(product.getId());
            productToAdd.setName(product.getName());
            productToAdd.setPrice(product.getPrice()*dollarExchangeRate);
            newProducts.add(productToAdd);

        }
        return newProducts;
    }

    public List<Product> calculateNewPriceByEuros(){
        float dollarExchangeRate=getExchangeById(2L).get().getExchangeRate();
        ObjectMapper mapper = new ObjectMapper(); // or inject it as a dependency
        List<Product> products = mapper.convertValue(getProducts(), new TypeReference<List<Product>>() { });

        List<Product> newProducts= new ArrayList<>();
        for (Product product:products) {
            Product productToAdd= new Product();
            productToAdd.setId(product.getId());
            productToAdd.setName(product.getName());
            productToAdd.setPrice(product.getPrice()*dollarExchangeRate);
            newProducts.add(productToAdd);

        }
        return newProducts;
    }


}
