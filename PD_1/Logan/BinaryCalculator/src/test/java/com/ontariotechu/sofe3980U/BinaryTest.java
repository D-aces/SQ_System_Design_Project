package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import java.beans.Transient;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor()
    {
		Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
		Binary binary=new Binary("1001001211");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
		Binary binary=new Binary("1001001A");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
		Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * T	est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
		Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
		Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
	/**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
		Binary binary1=new Binary("1000");
		Binary binary2=new Binary("1111");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void add3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void add4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
	/**
     * Test The add functions with two zeros
     */
    @Test
    public void add5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
    /**
     * Test the ORop function for an output of all 1's
     */
    @Test
    public void ORopTest(){
        Binary num1 = new Binary("010101");
        Binary num2 = new Binary("101010");

        Binary result = Binary.ORop(num1, num2);

        assertTrue(result.getValue().equals("111111"));
    }
    /**
     * Test the ANDop function for an output of all zeros
     */
    @Test
    public void ANDopTest(){
        Binary num1 = new Binary("111111");
        Binary num2 = new Binary("0");

        Binary result = Binary.ANDop(num1, num2);

        assertTrue(result.getValue().equals("0"));
    }
    /**
     * Another test for ANDop for a non constant output
     */
    @Test
    public void ANDopSecondTest(){
        Binary num1 = new Binary("011110");
        Binary num2 = new Binary("011011");

        Binary result = Binary.ANDop(num1, num2);

        assertTrue(result.getValue().equals("11010"));
    }
    /**
     * Test the multiply function with binary 6 and binary 2
     */
    @Test
    public void multiplyTest(){
        Binary num1 = new Binary("110");
        Binary num2 = new Binary("10");

        Binary result = Binary.multiply(num1, num2);

        assertTrue(result.getValue().equals("1100"));
    }
}
