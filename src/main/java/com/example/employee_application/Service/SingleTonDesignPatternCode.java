package com.example.employee_application.Service;

public class SingleTonDesignPatternCode {

    public static void main(String[] args){

        Execute execute  = new Execute().getInstance();
        System.out.println(execute.add(5, 5));
    }

}

class Execute{

    private static Execute execute = new Execute();

    Execute(){

    }

    public static Execute getInstance(){
        return execute;
    }

    int add(int a ,int b){
        
        return a+b;
    }


}


