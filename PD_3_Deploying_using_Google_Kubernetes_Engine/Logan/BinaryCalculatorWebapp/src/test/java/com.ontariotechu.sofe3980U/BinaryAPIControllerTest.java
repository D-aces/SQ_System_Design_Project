package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
    public void and() throws Exception {
        this.mvc.perform(get("/and").param("operand1","111111").param("operand2","101010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("101010"));
    }

    @Test
    public void or() throws Exception {
        this.mvc.perform(get("/or").param("operand1","101010").param("operand2","010101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("111111"));
    }

    @Test
    public void multiply() throws Exception {
        this.mvc.perform(get("/multi").param("operand1","1111").param("operand2","0001"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("1111"));
    }

    @Test
    public void and2() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","111111").param("operand2","101010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(101010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(101010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    @Test
    public void or2() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","101010").param("operand2","010101"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(101010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(10101))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(111111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    @Test
    public void multiply2() throws Exception {
        this.mvc.perform(get("/multi_json").param("operand1","1111").param("operand2","0001"))//.andDo(print())
            .andExpect(status().isOk())
            //Please play arround with the values within this method. For some reason the compiler will read the wrong values inside the
            //value()'s. if you put 0010 in value() for operand2 it was reading 8. I don't know why ¯\_(ツ)_/¯
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
}