package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should conatins only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
    public Binary(String number) {
		for (int i = 0; i < number.length(); i++) {
			// check each character if it's not 0 or 1
			char ch=number.charAt(i);
			if(ch!='0' && ch!='1') {
				number="0"; // if not store "0" and end the function
				return;
			}
		}
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any

		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}
    }
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1 + num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
	}

	/**
	 * Bitwise Logical OR
	 * @param n1 First operand
	 * @param n2 Second operand
	 * @return A binary variable with a value of <i>n1 OR n2</i>.
	 */
	public static Binary or(Binary n1, Binary n2)
	{
		int length1 = n1.number.length();//Length of the first operand
		int length2 = n2.number.length();//Length of the second operand
		int maxLength = Math.max(length1, length2);//Length of the result
	
		StringBuilder result = new StringBuilder(maxLength);//Return value
	
		for (int i = 0; i < maxLength; i++) {
			char b1 = (i < length1) ? n1.number.charAt(length1 - 1 - i) : '0';//Get the current bit of n1
			char b2 = (i < length2) ? n2.number.charAt(length2 - 1 - i) : '0';//Get the current bit of n2
	
			switch (b1)//Perform bitwise OR on the current bit of n1 
			{
				case '0'://If the current bit of n1 is 0
					result.append((b2 == '0') ? '0' : '1');//The result is the current bit of n2
					break;
				case '1'://If the current bit of n1 is 1
					result.append('1');//The result is 1
					break;
				default://If the current bit of n1 is not 0 or 1
					throw new IllegalArgumentException("Invalid character in input string: " + b1);
			}
		}
	
		return new Binary(result.reverse().toString());//Return the result
	}
	
	/**
	 * Bitwise Logical AND
	 * @param n1 First operand
	 * @param n2 Second operand
	 * @return A binary variable with a value of <i>n1 AND n2</i>.
	 */
	public static Binary and(Binary n1, Binary n2)
	{
		int length1 = n1.number.length();//Length of the first operand
		int length2 = n2.number.length();//Length of the second operand
		int maxLength = Math.max(length1, length2);//Length of the result
	
		StringBuilder result = new StringBuilder(maxLength);//Return value
	
		for (int i = 0; i < maxLength; i++) {
			char b1 = (i < length1) ? n1.number.charAt(length1 - 1 - i) : '0';//Get the current bit of n1
			char b2 = (i < length2) ? n2.number.charAt(length2 - 1 - i) : '0';//Get the current bit of n2
	
			switch (b1)//Perform bitwise AND on the current bit of n1 
			{
				case '0'://If the current bit of n1 is 0
					result.append('0');//The result is 0
					break;
				case '1'://If the current bit of n1 is 1
					result.append((b2 == '0') ? '0' : '1');//The result is the current bit of n2
					break;
				default://If the current bit of n1 is not 0 or 1
					throw new IllegalArgumentException("Invalid character in input string: " + b1);
			}
		}
	
		return new Binary(result.reverse().toString());//Return the result
	}

	/**
	 * Binary Multiplication
	 * @param n1 First operand
	 * @param n2 Second operand
	 * @return A binary variable with a value of <i>n1 x n2</i>.
	 */
	public static Binary mult(Binary n1, Binary n2)
	{
		Binary res = new Binary("0");//Return value
	
		for (int i = 0; i < n2.number.length(); i++) 
		{
			if (n2.number.charAt(n2.number.length() - 1 - i) == '1')//If the current bit of n2 is 1
				res = add(res, n1);//Add n1 to the result
	
			n1 = new Binary(n1.number + "0");//Multiply n1 by 2
		}
	
		return res;//Return the result
	}
}	