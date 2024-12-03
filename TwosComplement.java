/**
 * This program asks user to enter 16 zeros or ones representing a binary number.then displays its signed decimal number.
 */
import java.util.Scanner;
public class TwosComplement {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String bin;
        int dec;

        do{
            System.out.println("Enter 16 zeros or ones: "); 
            bin = scan.nextLine();

        }while(!verify(bin));

        if(bin.charAt(0) == '0'){
            dec = convertToDec(bin);
            
        }else{
            dec = negativeConvert(bin);

        }
        System.out.println(bin + " converts to decimal: " + dec);

    }

    //Verify user input
    public static boolean verify(String bin){

        if(bin.length() != 16){
            System.out.println("Error: the input length is not 16.");
            return false;
        }
        else{
            for(int i = 0; i < bin.length(); i++){

                if(bin.charAt(i) != '0' && bin.charAt(i) != '1'){
                    System.out.println("Error: input should be 1 or 0.");
                    return false;
                }        
            }
        }
        return true;
    }

    public static int convertToDec(String bin){
        int dec = 0, pow = 15;

        for(int i = 0; i < bin.length(); i++){

            if(bin.charAt(i) == '1')
                dec += Math.pow(2, pow);
            
            pow--;
        }
        return dec;
    }

    public static int negativeConvert(String bin){

        int dec = 0;
        bin = complement(bin);
        bin = addOne(bin);

        dec = convertToDec(bin);

        return dec;
    }

    public static String complement(String bin){

        String result = "";

        for(int i = 0; i < bin.length(); i++){

            if(bin.charAt(i) == '1')
                result += '0';
            else   
                result += '1';
        }
        
        return result;
    }

    public static String addOne(String bin){

        String result = "";

        return result;
    }
}
