package com.company;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continueOperations = false;
        HashMap<String,String> valuesAndOperations;
        HashMap<String,Integer> results = new HashMap<>();
        results.put("a",1);

        while (!continueOperations) {
            System.out.println("Ingrese el comando");
            Scanner input = new Scanner(System.in);
            Values values = new Values(input.nextLine());
            values.isValidOperation();
            valuesAndOperations = values.getValues();
            Operations operation = new Operations(valuesAndOperations.get("operation"));
            continueOperations = operation.choseOperation(valuesAndOperations,results);
        }
    }
}
