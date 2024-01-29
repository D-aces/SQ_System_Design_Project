package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

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
     * Test The constructor with a string containing only multiple zeros
     */
    @Test
    public void constructorMultiZero()
    {
		Binary binary=new Binary("00000");
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
     * Test the or function with single bit numbers
    */
    @Test
    public void or(){
	    Binary binary1=new Binary("0");
	    Binary binary2=new Binary("1");
	    Binary binary3=Binary.or(binary1,binary2);
	    assertTrue(binary3.getValue().equals("1"));
    }
    /**
     * Test the or function with two zeros
    */
    @Test
    public void or2(){
	    Binary binary1=new Binary("0");
	    Binary binary2=new Binary("0");
	    Binary binary3=Binary.or(binary1,binary2);
	    assertTrue(binary3.getValue().equals("0"));
    }
    /**
     * Test the or function with two ones
    */
    @Test
    public void or3(){
	    Binary binary1=new Binary("1");
	    Binary binary2=new Binary("1");
	    Binary binary3=Binary.or(binary1,binary2);
	    assertTrue(binary3.getValue().equals("1"));
    }
    /**
     * Test The or functions with two binary numbers, the first argument has more digits than the second
     */
    @Test
    public void or4()
    {
        Binary binary1=new Binary("1010");
        Binary binary2=new Binary("11");
        Binary binary3=Binary.or(binary1,binary2);
        assertTrue( binary3.getValue().equals("1011"));
    }
    /**
     * Test The or functions with two binary numbers, checking a longer and rarer case
     */
    @Test
    public void or5()
    {
        Binary binary1=new Binary("00000000");
        Binary binary2=new Binary("11111111");
        Binary binary3=Binary.or(binary1,binary2);
        assertTrue( binary3.getValue().equals("11111111"));
    }
    /**
     * Test The simplist case for the and function with two binary numbers
     */
    @Test
    public void and()
    {
        Binary binary1=new Binary("0");
        Binary binary2=new Binary("1");
        Binary binary3=Binary.and(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
    /**
     * Test What happens to binary numbers with leading zeros
     */
    @Test
    public void and2()
    {
        Binary binary1=new Binary("11");
        Binary binary2=new Binary("01");
        Binary binary3=Binary.and(binary1,binary2);
        assertTrue(binary3.getValue(), binary3.getValue().equals("1"));
    }
    /**
     * Test What happens to binary numbers of different length
     */
    @Test
    public void and3()
    {
        Binary binary1=new Binary("111");
        Binary binary2=new Binary("101");
        Binary binary3=Binary.and(binary1,binary2);
        assertTrue( binary3.getValue().equals("101"));
    }
    /**
     * Test the multiplication method works under normal conditions
     */
    @Test
    public void multiply()
    {
        Binary binary1=new Binary("101");
        Binary binary2=new Binary("111");
        Binary binary3=Binary.multiply(binary1,binary2);
        assertTrue(binary3.getValue(), binary3.getValue().equals("100011"));
    }
    /**
     * Test the multiplication method works under different lengths and with leading zeros
     */
    @Test
    public void multiply2()
    {
        Binary binary1=new Binary("00101");
        Binary binary2=new Binary("11111");
        Binary binary3=Binary.multiply(binary1,binary2);
        assertTrue(binary3.getValue(), binary3.getValue().equals("10011011"));
    }
     /**
     * Test the multiplication method works with all zeroes
     */
    @Test
    public void multiply3()
    {
        Binary binary1=new Binary("00");
        Binary binary2=new Binary("11111");
        Binary binary3=Binary.multiply(binary1,binary2);
        assertTrue(binary3.getValue(), binary3.getValue().equals("0"));
    }
}
