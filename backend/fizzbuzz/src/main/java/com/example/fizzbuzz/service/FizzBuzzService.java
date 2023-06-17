package com.example.fizzbuzz.service;


import com.example.fizzbuzz.dto.CreateResultResponse;
import com.example.fizzbuzz.dto.Response;

public interface FizzBuzzService {

    Response createResult(Integer min, Integer max);
}
