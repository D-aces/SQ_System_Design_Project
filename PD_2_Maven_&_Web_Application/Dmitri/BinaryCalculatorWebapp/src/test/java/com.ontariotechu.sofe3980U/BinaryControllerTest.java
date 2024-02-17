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
import static org.hamcrest.Matchers.nullValue;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

    /**
     * Testing the default path for the web application
     */
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", ""))
			.andExpect(model().attribute("operand1Focused", false));
    }

    /**
     * Testing parameter 1 (operand1) is passed as an initial value
     */
    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1","111"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand1Focused", true));
    }

    /**
     * Testing non-binary values being passed to parameter 1 (operand1) as an initial value
     */
    @Test
    public void getParameter2() throws Exception {
        this.mvc.perform(get("/").param("operand1","34232"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", ""));
    }
    
    /**
     * Testing post paramter with no operator field
     */

        @Test
    public void postParameter() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator", "").param("operand2", "111"))
            .andExpect(status().isOk())
            .andExpect(view().name("Error"))
	    		.andExpect(model().attribute("result", nullValue()))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand2", "111"));
    }

    /**
     * Testing add with no operand1, operator and operand2 pass string values accurately, then return a proper result for adding
     */

        @Test
    public void postParameterAdd3() throws Exception {
        this.mvc.perform(post("/").param("operand1","").param("operator", "+").param("operand2", "111"))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
	    		.andExpect(model().attribute("result", "111"))
			.andExpect(model().attribute("operand1", ""))
			.andExpect(model().attribute("operand2", "111"));
    }
        
    /**
     * Testing add with operand1 and operator pass string values accurately, and no operand2, then return a proper result for adding
     */
    @Test
    public void postParameterAdd2() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator", "+").param("operand2", ""))
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
	    		.andExpect(model().attribute("result", "111"))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand2", ""));
    }

    /**
     * Testing operand1, operator and operand2 pass string values accurately, then return a proper result for adding 
     */
	@Test
	    public void postParameterAdd() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","+").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "1110"))
			.andExpect(model().attribute("operand1", "111"));
    }

    /**
     * Testing operand1, operator and operand2 pass string values accurately, then return a proper result for bitwise and operation 
     */
	@Test
	    public void postParameterAnd() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","&").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "111"))
			.andExpect(model().attribute("operand1", "111"));
    }
    
    /**
     * Testing operand1, operator and operand2 pass string values accurately, then return a proper result for bitwise or operation 
     */
	@Test
	    public void postParameterOr() throws Exception {
        this.mvc.perform(post("/").param("operand1","100").param("operator","|").param("operand2","110"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "110"))
			.andExpect(model().attribute("operand1", "100"));
    }
    
    /**
     * Testing operand1, operator and operand2 pass string values accurately, then return a proper result for bitwise multiply operation 
     */
	@Test
	    public void postParameterMultiply() throws Exception {
        this.mvc.perform(post("/").param("operand1","111").param("operator","*").param("operand2","111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "110001"))
			.andExpect(model().attribute("operand1", "111"));
    }

}
