package com.company;
import java.util.HashMap;

public class ProcessValues {
    private static float value;
    private static String variable;
    private boolean processValues=true;

    public ProcessValues(String variable){
        ProcessValues.variable = variable;
    }

    public static boolean isNummber(){
        try {
            value = Float.parseFloat(variable);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void isInResults(HashMap<String,Float> results){
        if(results.containsKey(variable)) {
            value = results.get(variable);
        }else {
            processValues=false;
            System.out.println(variable +" was not saved yet");
        }
    }

    public boolean continueProcess (HashMap<String,Float> results) {
        if(ProcessValues.isNummber()){
            return true;
        }else{
            isInResults(results);
            return continueProcessValues();
        }
    }

    public float getValue(){
        return value;
    }
    private boolean continueProcessValues(){
        return processValues;
    }

}