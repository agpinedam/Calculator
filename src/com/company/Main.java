package com.company;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continueOperations=true;
        HashMap<String,String> valuesAndOperations;
        HashMap<String,Integer> results = new HashMap<>();

        while (continueOperations) {
            System.out.println("Enter the command");
            Scanner input = new Scanner(System.in);
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
