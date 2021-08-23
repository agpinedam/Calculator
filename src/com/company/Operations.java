package com.company;

import java.util.HashMap;

public class Operations {
    private final String operation;

    public Operations(String operation){
        this.operation=operation;
    }

    public boolean choseOperation(HashMap<String,String>valuesAndOperations,HashMap<String,Integer>results){
        boolean exit=false;
        switch (operation) {
            case "Exit" -> exit = true;
            case "Show" -> Show(valuesAndOperations.get("x"), results);
            default -> {
                GetXY intX = new GetXY(valuesAndOperations, results, "x");
                GetXY intY = new GetXY(valuesAndOperations, results, "y");
                if (intX.isContinueProcess() && intY.isContinueProcess()) {
                    int x = intX.getValue();
                    int y = intY.getValue();
                    calculate(operation, x, y);
                } else System.out.println("Please ingres valid values");
            }
        }
        return exit;
    }

    private void calculate(String operation, int x, int y){
        switch (operation){
            case "Sum"-> Sum(x,y);
            case "Minus" -> Minus(x,y);
            case "Multiply"-> Multiply(x,y);
            case "Divide"-> Divide(x,y);
        }
    }

    private void Show(String variable, HashMap<String,Integer> results){
        if (!results.containsKey(variable)){
            System.out.println("The variable "+variable+" was not saved yet");
        }else {
            System.out.println("The variable "+ variable+" has the value of "+ results.get(variable));
        }
    }

    private void Sum(int x, int y){
        System.out.println("Result is "+ (x+y) );
    }

    private void Minus(int x, int y){
        System.out.println("Result is "+ (x-y) );
    }

    private void Multiply(int x, int y){
        System.out.println("Result is "+ (x*y) );
    }
    private void Divide(int x, int y){
        System.out.println("Result is "+ (x/y) );
    }

}
