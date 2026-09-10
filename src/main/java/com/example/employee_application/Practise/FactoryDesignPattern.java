package com.example.employee_application.Practise;

public class FactoryDesignPattern {

    public static Payment getPayment(String type){

        if(type.equals("UPI")){

            return new UPIPayment();
        }else if(type.equals("CreditCard")){

            return new CreditCardPayment();
        }
        return null;
    }

}
