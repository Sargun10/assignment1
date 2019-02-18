
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sargun
 */
class Assignment1 {

    /**
     * This method is used to find random IDs out of given ArrayList.
     *
     * @param list This is the parameter to generateRandomIds method
     * @return ArrayList<Integer> This returns ArrayList of random IDs.
     */
    public static ArrayList<Integer> generateRandomIds(List<Integer> list) {
        Random rand = new Random();
        ArrayList<Integer> randomIdsBySystem = new ArrayList<>();
        while (randomIdsBySystem.size() < 6) {
            int randomId = rand.nextInt(list.size());
            if (!randomIdsBySystem.contains(randomId) && randomId != 0) {
                randomIdsBySystem.add(randomId);
            }
        }
        System.out.println("by system  " + randomIdsBySystem);
        return randomIdsBySystem;
    }

    /**
     * This method is used to find if given string is in alphabets.
     *
     * @param stringAny This is the parameter to isStringOnlyAlphabet method
     * @return boolean This returns true or false if given string is in
     * alphabets or not.
     */
    public static boolean isStringOnlyAlphabet(String stringAny) {
        return ((!stringAny.equals(""))
                && (stringAny != null)
                && (stringAny.matches("^[a-zA-Z]*$")));
    }

    /**
     * This is the main method which makes use of addNewCustomer,
     * isStringOnlyAlphabet, addCarDetails, getSortedList, getExistingCustomer,
     * showCustomerWiseInfo, getRandomIds method.
     *
     * @param args Unused.
     * @return Nothing.
     * @exception throws InputMismatchException if user enters invalid data.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean flag = true;
        do {
            System.out.println("************************");
            System.out.println("1. add new customer ");
            System.out.println("2. add new car to existing customer ");
            System.out.println("3. display sorted customers with cars ");
            System.out.println("4. list individual customer based on id ");
            System.out.println("5. generate prizes ");
            System.out.println("6. Exit");
            System.out.println("************************");
            Scanner sc = new Scanner(System.in);
            try {
                int choice = sc.nextInt();
                Admin admin = new Admin();

                switch (choice) {
                    case 1:
                        String name;
                        do {
                            System.out.println("enter valid name of customer ");
                            name = sc.next();
                        } while (!isStringOnlyAlphabet(name));
                        Customer customer = new Customer(name);
                        admin.addNewCustomer(customer);//adds new customer to the arraylist.
                        System.out.println("customer details added ");
                        admin.addCarDetails(customer);//adds new car to the arraylist of cars.
                        break;

                    case 2:
                        int idExisting;
                        do {
                            System.out.println("enter valid id of the customer ");
                            idExisting = sc.nextInt();
                        } while (admin.isExistingCustomer(idExisting));

                        boolean isExisting = admin.isExistingCustomer(idExisting);// if entered id exists then car is added to the arraylist.
                        if (isExisting) {
                            System.out.println("customer found in database ");
                            admin.addCarDetails(admin.getExistingCustomer(idExisting));
                        } else {
                            System.out.println("this id doesn't exist ");
                        }
                        break;

                    case 3:
                        System.out.println("-----");
                        admin.showSortedList();// prints list of sorted customers by name with their cars.
                        break;
                    case 4:
                        int customerId;
                        do {
                            System.out.println("enter valid id of the customer  ");
                            customerId = sc.nextInt();
                        } while (!admin.isExistingCustomer(customerId));
                        admin.showCustomerWiseInfo(customerId);//displays information about entered id.

                        break;

                    case 5:
                        ArrayList<Integer> allCustomerIds = new ArrayList<>();
                        ArrayList<Integer> random6Ids = new ArrayList<>();
                        ArrayList<Integer> random3Ids = new ArrayList<>();
                        allCustomerIds = admin.addAllCustomerIds();
                        random6Ids = generateRandomIds(allCustomerIds);//generate random 6 ids out of existing ids.
                        random3Ids = admin.enterRandom3Ids();//takes 3 ids from user as input.
                        admin.generatePrizes(random6Ids, random3Ids);//generate an id that is common in both lists.
                        System.out.println("congratulations to the winners ");
                        break;
                    case 6:
                        flag = false;//to exit from the main menu.
                        break;
                }

            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("you have entered invalid data");
            }

        } while (flag == true);
    }

}
