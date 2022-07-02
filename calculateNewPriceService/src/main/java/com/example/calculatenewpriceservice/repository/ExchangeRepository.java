package com.example.calculatenewpriceservice.repository;

import com.example.calculatenewpriceservice.entity.Exchange;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends CrudRepository<Exchange, Long> {

}
