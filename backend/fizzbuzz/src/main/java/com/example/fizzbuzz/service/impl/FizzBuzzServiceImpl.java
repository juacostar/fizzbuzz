package com.example.fizzbuzz.service.impl;

import com.example.fizzbuzz.dto.CreateResultError;
import com.example.fizzbuzz.dto.CreateResultResponse;
import com.example.fizzbuzz.dto.Response;
import com.example.fizzbuzz.entity.Results;
import com.example.fizzbuzz.respository.ResultRepository;
import com.example.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {


    @Autowired
    private ResultRepository resultRepository;

    @Override
    public Response createResult(Integer min, Integer max) {

        Response response = new Response();

        if(min > max || min < -50 || max > 50){
            CreateResultError createResultError = new CreateResultError();
            createResultError.setTimestamp(new Date().toString());
            createResultError.setStatus(HttpStatus.BAD_REQUEST.value());
            createResultError.setError("Bad Request");
            createResultError.setException("com.intraway.exceptions.badrequest");
            createResultError.setMessage("Los parámetros enviados son incorrectos");
            createResultError.setPath("/intraway/api/fizzbuzz/" + min + "/" + max);


            response.setCreateResultError(createResultError);
        }else{
            Results results = new Results();

            CreateResultResponse createResultResponse = new CreateResultResponse();
            createResultResponse.setTimestamp(new Date().toString());
            createResultResponse.setDescription("Se encontraron múltiplos de " + min + " y de " + max);
            createResultResponse.setList(generateListField(min, max));

            results.setResult(createResultResponse.getList());
            results.setMin(min);
            results.setMax(max);

            Results saved = resultRepository.save(results);
            createResultResponse.setCode(String.format("%03d", saved.getId()));

            response.setCreateResultResponse(createResultResponse);
        }
        return  response;
    }

    public String generateListField(Integer min, Integer max){

        StringBuilder result = new StringBuilder();

        for(int i=min; i<=max; i++){
            if(i%3==0 && i%5==0) result.append("FizzBuzz");
            else if(i%3==0) result.append("Fizz,");
            else if(i%5==0) result.append("Buzz,");
            else result.append(i).append(",");
        }
        return (result.toString().charAt(result.length() - 1) == ',') ? result.substring(0,result.length() -1): result.toString();
    }
}
