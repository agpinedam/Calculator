package com.company;
import java.util.HashMap;

public class GetXY {
    private final HashMap<String,String> valuesAndOperations;
    private final HashMap<String,Integer> results;
    String variable;
    private int value;
    boolean continueProcess = true;

    public GetXY(HashMap<String,String> valuesAndOperations,HashMap<String,Integer> results, String variable){
        this.valuesAndOperations = valuesAndOperations;
        this.results=results;
        this.variable =variable;
    }

    private void isValue(){
        ProcessValues valueX = new ProcessValues(valuesAndOperations.get(variable));
        if(valueX.continueProcess(results)){
            value = valueX.getValue();
        }else {
            continueProcess = false;
        }
    }
    public boolean isContinueProcess(){
        isValue();
        return continueProcess;
    }
    public int getValue(){
        return value;
    }
}
