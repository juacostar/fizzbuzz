package com.example.fizzbuzz.respository;

import com.example.fizzbuzz.entity.Results;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends CrudRepository<Results,Integer> {
}
