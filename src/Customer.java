
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
    protected String customerName;
    // constructor is to give entered name to the customer.
    Customer(String customerName){
        this.customerName=customerName;
    }
}
