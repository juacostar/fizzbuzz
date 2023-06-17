package com.example.fizzbuzz;

import com.example.fizzbuzz.dto.Response;
import com.example.fizzbuzz.service.FizzBuzzService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = FizzbuzzApplication.class)
@AutoConfigureMockMvc
public class FizzBuzzTest {

    private final Jackson2ObjectMapperBuilder mapperBuilder = new Jackson2ObjectMapperBuilder();
    private final ObjectMapper objectMapper = mapperBuilder.build();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FizzBuzzService fizzBuzzService;


    @Test
    void createResult() throws Exception {
        String uri = "/intraway/api/fizzbuzz/1/3";
        String listExpected = "1,2,Fizz";
        ResultActions resultActions = this.mockMvc.perform(get(uri)).andExpect(status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        Response responseObtained = objectMapper.readValue(response, Response.class);
        assertEquals(responseObtained.getCreateResultResponse().getList(), listExpected);

    }
}
