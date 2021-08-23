package com.company;

import java.util.HashMap;
import java.util.Objects;

public class Operations {
    private final String operation;
    private int result;
    private final HashMap<String,Integer>results;
    private boolean exit=true;

    public Operations(String operation,HashMap<String,Integer> results){
        this.operation=operation;
        this.results=results;
    }

    public void choseOperation(HashMap<String,String>valuesAndOperations){
        switch (operation) {
            case "Exit" -> exit = false;
            case "Show" -> Show(valuesAndOperations.get("x"), results);
            default -> {
                GetXY intX = new GetXY(valuesAndOperations, results, "x");
                GetXY intY = new GetXY(valuesAndOperations, results, "y");
                if (intX.isContinueProcess() && intY.isContinueProcess()) {
                    int x = intX.getValue();
                    int y = intY.getValue();
                    calculate(operation, x, y);
                    if(result!=Integer.MAX_VALUE) System.out.println("The result is "+result);
                    save(valuesAndOperations.get("result"),result);
                } else System.out.println("Please enter valid values");
            }
        }
    }

    private void calculate(String operation, int x, int y){
        switch (operation){
            case "Sum"-> result=x+y;
            case "Minus" -> result=x-y;
            case "Multiply"-> result=x*y;
            case "Divide"-> {
                if(y!=0) result=x/y;
                else {result=Integer.MAX_VALUE;
                    System.out.println("Invalid operation, division by 0");}
            }
        }
    }

    private void Show(String variable, HashMap<String,Integer> results){
        if (!results.containsKey(variable))System.out.println("The variable "+variable+" was not saved yet");
        else System.out.println("The variable "+ variable+" has the value of "+ results.get(variable));
    }
    private void save(String value,Integer result){
        if(!Objects.equals(value, "") && result!=Integer.MAX_VALUE){
            results.put(value,result);
        }
    }
    public HashMap<String,Integer> getResults(){
        return results;
    }
    public boolean continueOperation(){return exit;}

}
