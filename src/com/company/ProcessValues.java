package com.company;
import java.util.HashMap;

public class ProcessValues {
    private static int value;
    private static String variable;
    private boolean processValues=true;

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
        }else {
            processValues=false;
            System.out.println(variable +" was not saved yet");
        }
    }

    public boolean continueProcess (HashMap<String,Integer> results) {
        if(ProcessValues.isNummber()){
            return true;
        }else{
            isInResults(results);
            return continueProcessValues();
        }
    }

    public int getValue(){
        return value;
    }
    private boolean continueProcessValues(){
        return processValues;
    }

}