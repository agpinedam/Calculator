package com.company;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continueOperations=true;
        HashMap<String,String> valuesAndOperations;
        HashMap<String,Float> results = new HashMap<>();
        Scanner input = new Scanner(System.in);

        while (continueOperations) {
            System.out.println("Enter the command");
            SplitValues splitValues = new SplitValues(input.nextLine());
            if(splitValues.isValidCommand()){
                valuesAndOperations = splitValues.getSplitValues();
                Operations operation = new Operations(valuesAndOperations.get("operation"),results);
                operation.choseOperation(valuesAndOperations);
                continueOperations = operation.continueOperation();
                results=operation.getResults();
            }
        }
    }
}
