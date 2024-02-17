package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
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
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", ""))
			.andExpect(model().attribute("operand1Focused", false));
    }
	
	@Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1","111"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand1Focused", true));
    }

	@Test
	public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1110"))
			.andExpect(model().attribute("operand1", "111"));
    }

    @Test
        public void getParameter2() throws Exception {
            this.mvc.perform(get("/").param("operand1", "0"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
            .andExpect(model().attribute("operand1", "0"))
            .andExpect(model().attribute("operand1Focused", true));
        }
    
    @Test
    public void postBadOp() throws Exception {
        this.mvc.perform(post("/").param("operand1","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("Error"))
			.andExpect(model().attribute("operand1", "111"));
    }

    @Test
    public void postBadOp2() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("Error"))
			.andExpect(model().attribute("operand2", "111"))
			.andExpect(model().attribute("operand1", "111"));
    }

    @Test
    public void andOP() throws Exception {
        this.mvc.perform(post("/").param("operand1","101").param("operator", "&").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("operand1", "101"))
			.andExpect(model().attribute("operand2", "111"))
            .andExpect(model().attribute("result", "101"));
    }

    @Test
    public void orOP() throws Exception {
        this.mvc.perform(post("/").param("operand1","001100").param("operator", "|").param("operand2","100001"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("operand1", "001100"))
			.andExpect(model().attribute("operand2", "100001"))
            .andExpect(model().attribute("result", "101101"));
    }

    @Test
    public void multiplyOP() throws Exception {
        this.mvc.perform(post("/").param("operand1","11001").param("operator", "*").param("operand2","010001"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
            .andExpect(model().attribute("operand1", "11001"))
			.andExpect(model().attribute("operand2", "010001"))
            .andExpect(model().attribute("result", "110101001"));
    }
}