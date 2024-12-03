/**
 * This program asks user to enter 16 zeros or ones representing a binary number.then displays its signed decimal number.
 * 
 * Test sets:
 * 0100111100001100   20236
 * 1100111100001100   -12532
 * 1000000000000000   -32768
 * 1111111111111111   -1
 */

import java.util.Scanner;
public class TwosComplement {

    public static final int NUMBER_OF_BITS = 16;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String bin;

        do{
            System.out.println("Enter 16 zeros or ones: "); 
            bin = scan.nextLine();

        }while(!verify(bin));
       
        System.out.println("Converts to decimal: " + convert(bin));
    }

    //Verify user input
    public static boolean verify(String bin){

        boolean flag = true;

        if(bin.length() != NUMBER_OF_BITS){
            System.out.println("Error: the number of bits should be " + NUMBER_OF_BITS);
            flag = false;
        }

        for(int i = 0; i < NUMBER_OF_BITS; i++){

            if(bin.charAt(i) != '0' && bin.charAt(i) != '1'){

                System.out.println("Error: input should be 1 or 0.");
                flag = false;
            }        
        }
        
        return flag;
    }

    //Converting from binary to decimal
    public static int convert(String bin){

        int result = 0, sign = 1;

        if(bin.charAt(0) == '1'){

            sign = -1;
            bin = complement(bin);
            bin = addOne(bin); 
        }

        result = calculateDec(bin) * sign;
        return result;
    }

    //Flip the 1s and 0s
    public static String complement(String bin){

        String result = "";

        //Flip 1 and 0 except sign bit
        for(int i = 1; i < bin.length(); i++){

            if(bin.charAt(i) == '1')
                result += '0';
            else   
                result += '1';
        }
        //add back sign bit
        result = bin.charAt(0) + result;
        System.out.println("After complement:" + result);
        return result;
    }

    public static String addOne(String bin){

        String result = "";

        int i = NUMBER_OF_BITS - 1;

        while(bin.charAt(i) == '1'){
            result = '0' + result;
            i--;
        }

        result = '1' + result;

        result = bin.substring(0, i) + result;

        System.out.println("After add one:   " + result);
        return result;
    }

    //using 2 to power of 0,1,2,3...15 to calculate decimal
    public static int calculateDec(String bin){
        int dec = 0, pow = NUMBER_OF_BITS - 2;

        for(int i = 1; i < bin.length(); i++){

            if(bin.charAt(i) == '1')
                dec += Math.pow(2, pow);
            
            pow--;
        }
        return dec;
    }
}
