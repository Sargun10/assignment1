package entity;

import comparator.SortByName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sargun
 */
public class Admin {

    private static ArrayList<Customer> customerAl = new ArrayList<>();

    /**
     * This method is used to add new customer in the customer array list.
     *
     * @param c This is the parameter to addNewCustomer method
     */
    public void addNewCustomer(Customer c) {
        customerAl.add(c);
        c.customerId = customerAl.size();

    }

    /**
     * This is the method which is used to add all customer Ids in one array
     * list.
     *
     * @return array list of customer Ids.
     */
    public ArrayList<Integer> addAllCustomerIds() {
        ArrayList<Integer> allCustomerIds = new ArrayList<>();
        if (customerAl.size() > 6) {
            for (Customer c : customerAl) {

                allCustomerIds.add(c.customerId);
            }
            return allCustomerIds;
        } else {
            return null;
        }

    }

    /**
     * This is the method which is used to add car details once user is added.
     *
     * @param Customer type object c.
     * @return Nothing.
     * @exception throws InputMismatchException if user enters invalid data.
     */
    public void addCarDetails(Customer c) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("enter car details ");
            System.out.println("enter car type : \n1. Toyota \n 2. Maruti \n 3. Hyundai ");
            String carType = sc.next();
            System.out.println("enter model and price of the car ");
            String carModel = sc.next();
            double carPrice = sc.nextDouble();
            switch (carType.toLowerCase()) {
                case "toyota":
                    Toyota t = new Toyota(carModel, carPrice, c);
                    c.carAl.add(t);// if user selects toyota
                    break;
                case "maruti":
                    Maruti m = new Maruti(carModel, carPrice, c);
                    c.carAl.add(m);//if user selects maruti
                    break;
                case "hyundai":
                    Hyundai h = new Hyundai(carModel, carPrice, c);
                    c.carAl.add(h);//if user selects hyundai
                    break;
                default:
                    System.out.println("enter valid car type");
                    break;
            }
        } catch (InputMismatchException e) {
            sc.next();
            System.out.println("you have entered invalid data");
        }

    }

    /**
     * This is the method which is used to check if given user exists in array
     * list or not.
     *
     * @param existingId that exists or not.
     * @return boolean value if id exists or not.
     */
    public boolean isExistingCustomer(int existingId) {
        for (Customer customer : customerAl) {
            if (existingId == customer.customerId) {
                return true;
            }
        }
        return false;
    }

    /**
     * This is the method which is used to get customer object for which id has
     * been entered.
     *
     * @param existingId for which object is returned.
     * @return customer object for which id exists.
     */
    public Customer getExistingCustomer(int existingId) {
        for (Customer customer : customerAl) {
            if (existingId == customer.customerId) {
                return customer;
            }
        }
        return null;
    }

    /**
     * This is the method which is used to display customer information for
     * entered id.
     *
     * @param id for which customer info is printed.
     */
    public void showCustomerInfo(int id) {
        for (Customer c : customerAl) {
            if (isExistingCustomer(id)) {
                System.out.println("Customer id :" + c.customerId + "  Customer name :" + c.getCustomerName());
            }
        }
    }

    /**
     * This is the method which is used to show sorted list of customers with
     * their cars by name. This method uses comparator interface SortByName to
     * sort array list of customers.
     */
    public void showSortedList() {
        Collections.sort(customerAl, new SortByName());
        System.out.println("sorted list :");
        for (Customer c : customerAl) {
            System.out.println("Customer id :" + c.customerId + "  Customer name :" + c.getCustomerName());
            for (Car car : c.carAl) {
                System.out.println("car id :" + car.carId + "  Car Name :" + car.carName + "  Model :" + car.model);
            }
        }
    }

    /**
     * This is the method which is used to display customer information about
     * entered id.
     *
     * @param id that exists or not is checked and then this function is used to
     * display information.
     */
    public void showCustomerWiseInfo(int id) {
        for (Customer c : customerAl) {
            if (id == c.customerId) {
                System.out.println("Customer id " + c.customerId + "\nCustomer name " + c.getCustomerName() + "\n");
                for (Car car : c.carAl) {
                    System.out.println("car id " + car.carId + "\nCar Name " + car.carName + "\n Model " + car.model + "\n Price " + car.price + "\n Resale value " + car.resaleValue);
                }
            }
        }

    }

    /**
     * This is the method which is used to get 3 random IDs from Admin so that
     * prizes can be generated.
     *
     * @return array list<Integer> is returned containing 3 integer values from
     * admin.
     */
    public ArrayList<Integer> enterRandom3Ids() {
        System.out.println("enter 3 random ids ");
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> random3IdsByAdmin = new ArrayList<>();
        try {
            for (int i = 0; i < 3; i++) {
                random3IdsByAdmin.add(sc.nextInt());
            }
        } catch (InputMismatchException e) {
            sc.next();
            System.out.println("you have entered invalid data ");
        }
        return random3IdsByAdmin;

    }

    /**
     * This is the method which is used to declare winners that are common in
     * list by Admin and list by system.
     *
     * @param: list of 6 ids by system and list of 3 ids by admin.
     */
    public void generatePrizes(List<Integer> list6Ids, List<Integer> list3Ids) {
        ArrayList<Integer> prizeWinners = new ArrayList<>(list6Ids);
        prizeWinners.retainAll(list3Ids);
        System.out.println("winner(s) : ");
        System.out.println(prizeWinners);
        for (int iPrizeWinners : prizeWinners) {
            showCustomerInfo(iPrizeWinners);
        }

    }
}
