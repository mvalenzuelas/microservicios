package com.example.calculatenewpriceservice.controller;

import com.example.calculatenewpriceservice.model.Product;
import com.example.calculatenewpriceservice.services.CalculateNewPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calculateNewPrice")
public class CalculateNewPriceController {

    @Autowired
    CalculateNewPriceService calculateNewPriceService;

    @GetMapping("/dollar")
    public List<Product> getProductsDollars(){return calculateNewPriceService.calculateNewPriceByDollars();}

    @GetMapping("/euro")
    public List<Product> getProductsEuros(){return calculateNewPriceService.calculateNewPriceByEuros();}






}
