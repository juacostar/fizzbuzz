package com.example.fizzbuzz.service.impl;

import com.example.fizzbuzz.dto.CreateResultResponse;
import com.example.fizzbuzz.entity.Results;
import com.example.fizzbuzz.respository.ResultRepository;
import com.example.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {


    @Autowired
    private ResultRepository resultRepository;

    @Override
    public CreateResultResponse createResult(Integer min, Integer max) {

        Results results = new Results();

        CreateResultResponse createResultResponse = new CreateResultResponse();
        createResultResponse.setTimestamp(new Date().toString());
        createResultResponse.setCode(String.format("%03d", results.getId()));
        createResultResponse.setDescription("Se encontraron múltiplos de " + min + "y de " + max);
        createResultResponse.setList(generateListField(min, max));

        results.setResult(createResultResponse.getList());
        results.setMin(min);
        results.setMax(max);

        resultRepository.save(results);

        return createResultResponse;
    }

    public String generateListField(Integer min, Integer max){

        StringBuilder result = new StringBuilder();

        for(int i=min; i<=max; i++){
            if(i%3==0 && i%5==0) result.append("FizzBuzz");
            else if(i%3==0) result.append("Fizz");
            else if(i%5==0) result.append("Buzz");
            else result.append(i);
        }

        return result.toString();
    }
}
