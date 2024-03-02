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
        this.mvc.perform(get("/"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", ""))
                .andExpect(model().attribute("operand1Focused", false));
    }

    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1", "111"))
                .andExpect(status().isOk())
                .andExpect(view().name("calculator"))
                .andExpect(model().attribute("operand1", "111"))
                .andExpect(model().attribute("operand1Focused", true));
    }

    @Test
    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "+").param("operand2", "111"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111"));
    }

    @Test
    public void postInvalidBinaryInput() throws Exception {
        //Testing when the input operands are not valid binary numbers
        this.mvc.perform(post("/").param("operand1", "2").param("operator", "+").param("operand2", "1010"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1010"));
    }

    @Test
    public void postEmptyOperands() throws Exception {
        //Testing when both operands are empty
        this.mvc.perform(post("/").param("operand1", "").param("operator", "+").param("operand2", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"));
    }

    @Test
    public void postSingleOperand() throws Exception {
        //Testing when only one operand is provided
        this.mvc.perform(post("/").param("operand1", "1010").param("operator", "+"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1010"));
    }

    @Test
    public void postMultiplication() throws Exception {
        //Testing multiplication
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "*").param("operand2", "10"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1110"))
                .andExpect(model().attribute("operand1", "111"));
    }

    @Test
    public void postANDOperation() throws Exception {
        //Testing AND operation
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "&").param("operand2", "101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "101"))
                .andExpect(model().attribute("operand1", "111"));
    }

    @Test
    public void postOROperation() throws Exception {
        //Testing OR operation
        this.mvc.perform(post("/").param("operand1", "111").param("operator", "|").param("operand2", "101"))
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "111"))
                .andExpect(model().attribute("operand1", "111"));
    }

}