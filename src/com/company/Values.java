package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Values {
    private final HashMap<String,String> Values = new HashMap<>();
    private final String[] nameValues = {"operation","x","y","result"};
    private final ArrayList<String> Operations = new ArrayList<>();

    private final String input;
    private String[] splitString;
    private boolean validOperation = true;

    public Values(String input){
        fillDefaultOperations();
        fillDefaultValues();
        this.input=input;
    }
    private void fillDefaultOperations(){
        Operations.add("Sum");
        Operations.add("Minus");
        Operations.add("Multiply");
        Operations.add("Divide");
        Operations.add("Show");
        Operations.add("Exit");
    }

    private void fillDefaultValues(){
        for (String nameValue : nameValues) {
            Values.put(nameValue, "");
        }
    }

    private void separateValues() {
        splitString = input.split(" ");
        if (Operations.contains(splitString[0])){
            fillValues();
        }else{
            validOperation=false;
            System.out.println("Invalid operation");
        }
    }

    private void fillValues(){
        if(splitString.length<5){
            for(int i=0;i<splitString.length;i++) {
                Values.put(nameValues[i], splitString[i]);
            }
        }else {
            validOperation=false;
            System.out.println("Invalid command");
        }
        System.out.println(Values);
    }

    public boolean isValidOperation(){
        separateValues();
        return validOperation;
    }

    public HashMap<String,String> getValues(){
        return Values;
    }

}

