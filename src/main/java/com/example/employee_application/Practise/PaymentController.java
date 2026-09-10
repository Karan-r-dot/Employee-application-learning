package com.example.employee_application.Practise;

public class PaymentController {

    public static void main(String[] args){
    
    Payment strategy = FactoryDesignPattern.getPayment("UPI"); //Factory Pattern

    strategy.payment("Hello UPI Payment");

    }
}
