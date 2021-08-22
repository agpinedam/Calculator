package com.company;

import java.util.HashMap;

public class ProcessValues {
    private static int value;
    private static String variable;

    public ProcessValues(String variable){
        ProcessValues.variable = variable;
    }

    public static boolean isNummber(){
        try {
            value = Integer.parseInt(variable);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void isInResults(HashMap<String,Integer> results){
        if(results.containsKey(variable)) {
            value = results.get(variable);
            System.out.println("x es "+ value);
        }else {
            System.out.println("Invalid operation");
        }
    }

    public int getValue(){
        return value;
    }
}