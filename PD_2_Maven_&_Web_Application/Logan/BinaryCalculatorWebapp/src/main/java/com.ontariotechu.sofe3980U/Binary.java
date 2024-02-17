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
		// uncomment the following code

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
	 * Removes any training zeros at the beginning of the binary number String
	 * 
	 */
	private void removeZeros(){
		// remove any trailing zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg)!='0')
				break;
		}
		//beg has the index of the first non zero digit in the number
		this.number=number.substring(beg); // exclude the trailing zeros if any
		// uncomment the following code

		if(this.number=="") { // replace empty strings with a single zero
			this.number="0";
		}
	}

	/**
	 * Sets a new value of the binary number String stored in "number" variable.
	 * 
	 * @param value A Binary number String
	 */
	public void setValue(String value){
		this.number = value; //assign new value to the Binary String variable "number"
		this.removeZeros(); // Call removeZeros()
	}

	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
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
	* Performing a Binary OR operation on 2 distinct Binary numbers
	*
	* @param num1 The first Binary Number
	* @param num2 The second Binary Number
	* @return A binary object that contains the bitwise OR operation of <i>num1</i> OR <i>num2</i>
	*/
	public static Binary ORop(Binary num1, Binary num2)
    {
        // Find the length of the two binary numbers
        int len1 = num1.number.length();
        int len2 = num2.number.length();

        // Determine the maximum length among the two
        int maxLength = Math.max(len1, len2);

        // Create arrays to hold the binary digits, padded with leading zeros if necessary

        char[] binary1 = String.format("%" + maxLength + "s", num1.number).replace(' ', '0').toCharArray();
        char[] binary2 = String.format("%" + maxLength + "s", num2.number).replace(' ', '0').toCharArray();

        // Perform bitwise OR operation
        String result = "";
        for (int i = 0; i < maxLength; i++) {
            result += (binary1[i] == '1' || binary2[i] == '1') ? '1' : '0';
        }

        return new Binary(result);
    }

	/**
	* Performing a Binary AND operation on 2 distinct Binary numbers
	*
	* @param num1 The first Binary Number
	* @param num2 The second Binary Number
	* @return A binary object that contains the bitwise AND operation of <i>num1</i> OR <i>num2</i>
	*/
    public static Binary ANDop(Binary num1, Binary num2)
    {
        // Find the length of the two binary numbers
        int len1 = num1.number.length();
        int len2 = num2.number.length();

        // Determine the maximum length among the two
        int maxLength = Math.max(len1, len2);

        // Create arrays to hold the binary digits, padded with leading zeros if necessary

        char[] binary1 = String.format("%" + maxLength + "s", num1.number).replace(' ', '0').toCharArray();
        char[] binary2 = String.format("%" + maxLength + "s", num2.number).replace(' ', '0').toCharArray();

        // Perform bitwise AND operation
        String result = "";
        for (int i = 0; i < maxLength; i++) {
            result += (binary1[i] == '1' && binary2[i] == '1') ? '1' : '0';
        }

        return new Binary(result);
    }

	/**
	* Performing Binary Multiplication with 2 distinct Binary Numbers
	*
	* @param adder The Binary Adder
	* @param multiplicand The Binary Multiplicand
	* @return A Binary object that contains the result of a binary multiplication of 2 binary number <i>adder * multiplicand</i>
	*/
	public static Binary multiply(Binary operand1, Binary multiplicand) {

        Binary result = new Binary("0");

		Binary adder = new Binary(operand1.getValue());

        //For each 'bit' in the multiplicand try adding the adder to the result
        for(int i = multiplicand.getValue().length()-1; i >= 0; i--) {
            //Add the adder to result
            if (multiplicand.getValue().charAt(i) == '1') {
                result.setValue(Binary.add(result, adder).getValue());

            } 
            //Shift adder left one bit
			if(i>0){
				adder.setValue(adder.getValue() + "0");
			}
        }

        return result;
    }
}	
