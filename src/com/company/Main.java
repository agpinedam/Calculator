package com.company;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean continueOperations = false;
        HashMap<String,String> valuesAndOperations= new HashMap<>();
        HashMap<String,Integer> results = new HashMap<>();
        results.put("a",1);
        String validOperation;

        while (!continueOperations) {
            System.out.println("Ingrese el comando");
            Scanner input = new Scanner(System.in);
            Values values = new Values(input.nextLine());
            values.isValidOperation();
            valuesAndOperations = values.getValues();
            validOperation= valuesAndOperations.get("operation");
            Operations operation = new Operations();
                switch (validOperation){
                    case "Exit":
                        continueOperations=true;
                    case "Show":
                        operation.Show(valuesAndOperations.get("x"),results);
                        break;
                    default:
                        GetXY intX = new GetXY(valuesAndOperations,results,"x");
                        GetXY intY = new GetXY(valuesAndOperations,results,"y");
                        if(intX.isContinueProcess() && intY.isContinueProcess()){
                            int x = intX.getValue();
                            int y = intY.getValue();
                            System.out.println("El valor de x es "+ x);
                            System.out.println("El valor de y es "+ y);
                            operation.Minus(x,y,"a");
                            continueOperations = false;
                        }else{
                            continueOperations = false;
                            System.out.println("Please ingres valid values");
                        }
                        break;
                }
        }
    }
}
