package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class SplitValues {
    private final HashMap<String,String> Values = new HashMap<>();
    private final String[] nameValues = {"operation","x","y","result"};
    private final ArrayList<String> splitString = new ArrayList<>();

    private final String input;
    private String[] splitStr;

    public SplitValues(String input){
        fillDefaultOperations();
        fillDefaultValues();
        this.input=input;
    }
    private void fillDefaultOperations(){
        splitString.add("Sum");
        splitString.add("Minus");
        splitString.add("Multiply");
        splitString.add("Divide");
        splitString.add("Show");
        splitString.add("Exit");
    }

    private void fillDefaultValues(){
        for (String nameValue : nameValues) {
            Values.put(nameValue, "");
        }
    }

    private void separateValues() {
        splitStr = input.split(" ");
        if (splitString.contains(splitStr[0])){
            fillValues();
        }else{
            System.out.println("Invalid operation");
        }
    }

    private void fillValues(){
        if(splitStr.length<5){
            for(int i=0;i<splitStr.length;i++) {
                Values.put(nameValues[i], splitStr[i]);
            }
        }else {
            System.out.println("Invalid command");
        }
    }

    public HashMap<String,String> getSplitValues(){
        separateValues();
        return Values;
    }

}

