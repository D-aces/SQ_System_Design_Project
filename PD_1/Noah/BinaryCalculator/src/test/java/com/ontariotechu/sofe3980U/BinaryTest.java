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
     * Test The constructor with a zero tailing valid binary value
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
     * Test The add function with two binary numbers of the same length
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
     * Test The add function with two binary numbers, the length of the first argument is greater than the second
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
     * Test The add function with two binary numbers, the length of the first argument is less than the second
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
     * Test The add function with a binary number and zero
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
     * Test The add function with two zeros
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
     * Test The or function with two binary numbers of the same length
     */
    @Test
    public void or()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("1011");
		Binary binary3=Binary.or(binary1, binary2);
        assertTrue( binary3.getValue().equals("1011"));
    }
    /**
     * Test The or function with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void or2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.or(binary1, binary2);
        assertTrue( binary3.getValue().equals("1011"));
    }
    /**
     * Test The or function with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void or3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.or(binary1, binary2);
        assertTrue( binary3.getValue().equals("1011"));
    }
    /**
     * Test The or function with a binary number and zero
     */
    @Test
    public void or4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1, binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
    /**
     * Test The or function with two zeros
     */
    @Test
    public void or5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1, binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
    /**
     * Test The and function with two binary numbers of the same length
     */
    @Test
    public void and()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("1011");
		Binary binary3=Binary.and(binary1, binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
    /**
     * Test The and function with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void and2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.and(binary1, binary2);
        assertTrue( binary3.getValue().equals("10"));
    }
    /**
     * Test The and function with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void and3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.and(binary1, binary2);
        assertTrue( binary3.getValue().equals("10"));
    }
    /**
     * Test The and function with a binary number and zero
     */
    @Test
    public void and4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.and(binary1, binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
    /**
     * Test The and function with two zeros
     */
    @Test
    public void and5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1, binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
    /**
     * Test The mult function with two binary numbers of the same length
     */
    @Test
    public void mult()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("1011");
		Binary binary3=Binary.mult(binary1, binary2);
        assertTrue( binary3.getValue().equals("1101110"));
    }
    /**
     * Test The mult function with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void mult2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.mult(binary1, binary2);
        assertTrue( binary3.getValue().equals("11110"));
    }
    /**
     * Test The mult function with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void mult3()
    {
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.mult(binary1, binary2);
        assertTrue( binary3.getValue().equals("11110"));
    }
    /**
     * Test The mult function with a binary number and zero
     */
    @Test
    public void mult4()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.mult(binary1, binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
    /**
     * Test The mult function with two zeros
     */
    @Test
    public void mult5()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.mult(binary1, binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
    /**
     * Test The mult function with a binary number and one
     */
    @Test
    public void mult6()
    {
		Binary binary1=new Binary("1");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.mult(binary1, binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
}