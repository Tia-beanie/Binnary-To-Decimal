/** Test sets:
* 0100111100001100   20236
* 1100111100001100   -12532
* 1000000000000000   -32768
* 1111111111111111   -1
*/

import java.util.*;
public class BinaryToDecimal
{
	public static final int NUMBER_OF_BITS = 16;
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String bin;
		
		do{
			System.out.println("Enter 16 0s and 1s: ");
			bin = input.nextLine();
		} while (!validateInput(bin));
		
		System.out.println("The binary number " + bin + " in memory is equal to:\n\t " +
				convertToInteger(bin));
	}
	
	public static boolean validateInput(String bin)
	{
		boolean flag = true;
		
		if (bin.length() != NUMBER_OF_BITS)
		{
			System.out.println("The number of bits should be " + NUMBER_OF_BITS);
			flag = false;
		}
		
		for (int i = 0; i < NUMBER_OF_BITS; i++)
		{
			char bit = bin.charAt(i);
			if (bit != '0' && bit != '1')
			{
				System.out.println("The binary number should include 0 or 1");
				return false;
			}
		}
		
		return flag;
	}
	
	public static int convertToInteger(String bin)
	{
		int sign = 1;
		if (bin.charAt(0) == '1')
		{
			sign = -1;
			bin = complement(bin);
			bin = addOne(bin);
		}
		
		return (sign * binaryToDecimal(bin));
	}
	
	public static String complement(String bin)
	{
		String result = "";
		for (int i = 1; i < bin.length(); i++)
		{
			if (bin.charAt(i) == '0')
				result = result + '1' ;
			else
				result = result + '0';
		}
		result = bin.charAt(0) + result;
		System.out.println("After complement:" + result);
		return result;
	}
	
	public static String addOne(String bin)
	{
		String result = "";
		
		for (int i = bin.length() -1; i >=0 ; i--)
		{
			if (bin.charAt(i) == '1')
				result = '0' + result;
			else
			{
				result = '1' + result;
					
				result = bin.substring(0, i) + result;
				break;
			}
		}
		
		System.out.println("After add one:   " + result);
		
		return result;
	}
	
	public static int binaryToDecimal(String bin)
	{
		int decimal = 0,
	        	power = 1;
		
		// i > 0, therefore not coungting the sign bit charAt(0) 
		for (int i = bin.length() - 1; i > 0; i--)
		{
			if (bin.charAt(i) == '1')
				decimal = decimal + power;
			
			power = power * 2;
		}
		
		return decimal;
	}
}