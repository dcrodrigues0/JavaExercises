package bin2Dec.src;

import java.util.Scanner;

public class Bin2Dec {

    public int convertBin2Dec(String binary){
        int decimal = 0;
        int expoente = 0;

        for (int i = binary.length(); i-- > 0;){
            if(Character.getNumericValue(binary.charAt(i)) != 1 && Character.getNumericValue(binary.charAt(i)) != 0){
                throw new IllegalArgumentException("Only availible integers bits between 1 and 0");
            }
            decimal += (Math.pow(2,expoente) * Integer.parseInt(String.valueOf(binary.charAt(i))));
            expoente++;
        }

        return decimal;
    }

    public static void main(String[] args) {

        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a binary number");

        String binary   = myObj.nextLine();
        Bin2Dec bin2Dec = new Bin2Dec();
        System.out.println("Your binary number is: " + binary);
        System.out.println("Your decimal number is: " +  bin2Dec.convertBin2Dec(binary));

    }
}
