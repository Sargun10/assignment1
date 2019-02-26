package entity;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sargun
 */
public class Customer {
    protected ArrayList<Car> carAl=new ArrayList<>();
    protected int customerId;
    private String customerName;
    // constructor is to give entered name to the customer.
    public Customer(String customerName){
        this.customerName=customerName;
    }
    public String getCustomerName(){
        return customerName;
    }
}
