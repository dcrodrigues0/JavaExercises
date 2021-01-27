package calculator.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {

    public List<String> getNumbersFromOperation(String mathOperation){

        for(int i = 0; i < mathOperation.length(); i++){
            //Removing operator
            try {
                return new ArrayList<>(Arrays.asList(
                        mathOperation.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)")
                ));
            }catch (IndexOutOfBoundsException e){
                System.out.println("Não foi possível realizar a operação.");
            }
        }

        return null;
    }

    public double getResult(String mathOperation){
        List<String> numbers = getNumbersFromOperation(mathOperation);
        double leftNumber = 0;
        double rightRight = 0;

        try {
            leftNumber = Double.parseDouble(numbers.get(0));
            rightRight= Double.parseDouble(numbers.get(2));
        }catch (NumberFormatException e){
            System.out.println("Não foi possível realizar o cálculo, verifique a operação!");
        }
        double result = 0;

        switch (numbers.get(1)){
            case "+":
                result = leftNumber + rightRight;
                break;
            case "-":
                result = leftNumber - rightRight;
                break;
            case "*":
                result = leftNumber * rightRight;
                break;
            case "/":
                result = leftNumber / rightRight;
                break;
            case "^":
                result = Math.pow(leftNumber,rightRight);
            break;
        }
        return result;
    }
}
