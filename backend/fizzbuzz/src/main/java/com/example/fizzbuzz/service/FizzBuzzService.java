package com.example.fizzbuzz.service;


import com.example.fizzbuzz.dto.CreateResultResponse;

public interface FizzBuzzService {

    CreateResultResponse createResult(Integer min, Integer max);
}
