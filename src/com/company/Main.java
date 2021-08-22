package com.company;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continueOperations = false;
        HashMap<String,String> valuesAndOperations = new HashMap<>();
        HashMap<String,Integer> results = new HashMap<>();
        results.put("a",1);
        int x;

        while (!continueOperations) {
            System.out.println("Ingrese el comando");
            Scanner input = new Scanner(System.in);
            Values values = new Values(input.nextLine());
            continueOperations = values.isValidOperation();
            if(continueOperations){
                valuesAndOperations = values.getValues();
            }
        }

        ProcessValues valueX = new ProcessValues(valuesAndOperations.get("x"));

        if(ProcessValues.isNummber()){
            x =  valueX.getValue();
            System.out.println("x es "+ x);
        }else{
            valueX.isInResults(results);
        }


    }
}
