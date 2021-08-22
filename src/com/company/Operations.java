package com.company;

import java.util.HashMap;

public class Operations {

    public void Show(String variable, HashMap<String,Integer> results){
        if (!results.containsKey(variable)){
            System.out.println("The variable "+variable+" was not saved yet");
        }else {
            System.out.println("The variable "+ variable+" has the value of "+ results.get(variable));
        }
    }


}
