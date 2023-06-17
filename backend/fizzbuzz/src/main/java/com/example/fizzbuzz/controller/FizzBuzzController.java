package com.example.fizzbuzz.controller;

import com.example.fizzbuzz.dto.CreateResultError;
import com.example.fizzbuzz.dto.CreateResultResponse;
import com.example.fizzbuzz.dto.Response;
import com.example.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Map;

@Controller
public class FizzBuzzController{

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @RequestMapping(value = "/intraway/api/fizzbuzz/{min}/{max}")
    public @ResponseBody ResponseEntity<Response> findList(@PathVariable Integer min, @PathVariable Integer max){
        Response response = fizzBuzzService.createResult(min, max);
        return ResponseEntity.ok(response);
    }

}
