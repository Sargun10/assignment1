package entity;


import entity.Customer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sargun
 */
public abstract class Car {
    
    protected String carName;
    protected int carId;
    protected String model;
    protected double price;
    protected double resaleValue;
    protected abstract double calResaleValue();// calculates resale value for 
    //all the three brands respectively in their implementation classes.
    
}

class Toyota extends Car{
    //constructor to initialise data members for toyota.
    Toyota(String carModel, double carPrice,Customer c){
        carName="Toyota";
        model=carModel;
        price=carPrice;
        carId++;
        resaleValue=calResaleValue();
    }
    //overriden function to calculate resale value of toyota.
    @Override
    public double calResaleValue(){
        return ((80*price)/100);
    }
}

class Maruti extends Car{
    //constructor to initialise data members for maruti.
    Maruti(String carModel, double carPrice,Customer c){
        carName="Maruti";
        model=carModel;
        price=carPrice;
        carId++;
        resaleValue=calResaleValue();
    }
    //overriden function to calculate resale value of maruti.
    @Override
    public double calResaleValue(){
        return ((60*price)/100);
    }
}

class Hyundai extends Car{
    //constructor to initialise data members for hyundai.
    Hyundai(String carModel, double carPrice,Customer c){
        carName="Hyundai";
        model=carModel;
        price=carPrice;
        carId++;
        resaleValue=calResaleValue();
    }
    //overriden function to calculate resale value of hyundai.
    @Override
    public double calResaleValue(){
        return ((40*price)/100);
    }
}
