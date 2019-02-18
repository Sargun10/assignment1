
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sargun
 */
public class SortByName implements Comparator<Customer> {
//overriden function compare that compares customer objects one by one wrt name.
    @Override
    public int compare(Customer o1, Customer o2) {
//        if(o1.customerNameo2.customerName){
//            return 1;
//        }
            return (o1.customerName.compareToIgnoreCase(o2.customerName));
    }
    
}
