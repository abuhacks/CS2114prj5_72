package prj5;

import java.util.HashMap;
import java.util.Map;

// -------------------------------------------------------------------------
/**
 * Used for sorting the information based off certain values.
 * 
 * @author naren
 * @version Nov 12, 2023
 */
public class SortingCalculator {

    // ~ Fields ................................................................
    private DoublyLinkedList<User> users;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new SortingCalculator object.
     * 
     * @param users2
     *            for the user to be;
     */
    public SortingCalculator(DoublyLinkedList<User> users2) {
        users = users2;
    }


    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Adds a user to the list.
     * 
     * @param user
     *            to be added
     */
    public void addToList(User user) {
        users.add(user);
    }


    // ----------------------------------------------------------
    /**
     * gets the list.
     * 
     * @return the full list.
     */
    public DoublyLinkedList<User> getList() {
        return users;
    }


    // ----------------------------------------------------------
    /**
     * Sorts the linked list by name.
     * 
     * @return the sorted list.
     */

    public DoublyLinkedList<User> sortByName() {

        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        DoublyLinkedList<String> names = new DoublyLinkedList<String>();
        for (int i = 0; i < users.getLength(); i++) {
            if (names.contains((users.getEntry(i).getChannelName()))) {
                continue;
            }
            names.add(users.getEntry(i).getChannelName());
            testVals.add(users.getEntry(i));
        }

        for (int i = 0; i < testVals.getLength(); i++) {
            for (int j = i + 1; j < testVals.getLength(); j++) {
                if (testVals.getEntry(i).getChannelName().compareToIgnoreCase(
                    testVals.getEntry(j).getChannelName()) > 0) {
                    User temp = testVals.getEntry(i);
                    testVals.replace(i, testVals.getEntry(j));
                    testVals.replace(j, temp);
                }
            }
        }
        return testVals;

    }


    // ----------------------------------------------------------
    /**
     * Sorts the list by traditional rate.
     * 
     * @param user3
     *            user to be checked
     * @return the sorted list.
     */
    @SuppressWarnings("cast")
    public double getTraditionalRate(User user3) {
        Map<String, Integer> newMap = new HashMap<String, Integer>();
        newMap.put("January", 1);
        newMap.put("February", 2);
        newMap.put("March", 3);
        newMap.put("April", 4);

        double tempComments = user3.getComments();
        double tempLikes = user3.getLikes();
        User temp = user3;

        for (int i = 0; i < users.getLength(); i++) {
            if (users.getEntry(i).getChannelName().equals(user3
                .getChannelName()) && users.getEntry(i) != user3) {
                tempComments += users.getEntry(i).getComments();
                tempLikes += users.getEntry(i).getLikes();

                if (newMap.get(temp.getMonth()) < newMap.get(users.getEntry(i)
                    .getMonth())) {
                    temp = users.getEntry(i);
                }
            }
        }

        return ((tempComments + tempLikes) / (double)temp.getFollowers()) * 100;
    }


    // ----------------------------------------------------------
    /**
     * Gets the reach rate of a user.
     * 
     * @param user3
     *            the user to input
     * @return the reach rate.
     */
    public double getReachRate(User user3) {
        double totalComments = user3.getComments();
        double totalLikes = user3.getLikes();
        double totalViews = user3.getViews();

        for (int i = 0; i < users.getLength(); i++) {
            if (users.getEntry(i).getChannelName().equals(user3
                .getChannelName()) && users.getEntry(i) != user3) {
                totalComments += users.getEntry(i).getComments();
                totalLikes += users.getEntry(i).getLikes();
                totalViews += users.getEntry(i).getViews();
            }
        }
        if (totalViews == 0) {
            return -Double.MAX_VALUE;
        }
        return ((totalComments + totalLikes) / totalViews) * 100;
    }


    // ----------------------------------------------------------
    /**
     * Returns a sorted linked list of the users.
     * 
     * @return a sorted linked list.
     */
    public DoublyLinkedList<User> sortByReachRate() {
        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        DoublyLinkedList<String> names = new DoublyLinkedList<String>();
        for (int i = 0; i < users.getLength(); i++) {
            if (names.contains((users.getEntry(i).getChannelName()))) {
                continue;
            }
            names.add(users.getEntry(i).getChannelName());
            testVals.add(users.getEntry(i));
        }
        for (int i = 0; i < testVals.getLength(); i++) {
            for (int j = i + 1; j < testVals.getLength(); j++) {
                if (getReachRate(testVals.getEntry(i)) < getReachRate(testVals
                    .getEntry(j))) {
                    User temp = testVals.getEntry(j);
                    testVals.replace(j, testVals.getEntry(i));
                    testVals.replace(i, temp);
                }
            }
        }
        return testVals;
    }


    // ----------------------------------------------------------
    /**
     * Sorts the data based on traditional rate.
     * 
     * @return the sorted list.
     */
    public DoublyLinkedList<User> sortByTraditionalRate() {
        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        DoublyLinkedList<String> names = new DoublyLinkedList<String>();
        for (int i = 0; i < users.getLength(); i++) {
            if (names.contains((users.getEntry(i).getChannelName()))) {
                continue;
            }
            names.add(users.getEntry(i).getChannelName());
            testVals.add(users.getEntry(i));
        }
        for (int i = 0; i < testVals.getLength(); i++) {
            for (int j = i + 1; j < testVals.getLength(); j++) {
                if (getTraditionalRate(testVals.getEntry(
                    i)) < getTraditionalRate(testVals.getEntry(j))) {
                    User temp = testVals.getEntry(i);
                    testVals.replace(i, testVals.getEntry(j));
                    testVals.replace(j, temp);
                }
            }

        }
        return testVals;
    }
    
    // ----------------------------------------------------------
    /**
     * Sorts based off months.
     * @param month
     * @return the new list without months
     */
    public DoublyLinkedList<User> sortByTradMonth(String month) {
        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        for (int i = 0; i < users.getLength(); i++) {
            if (users.getEntry(i).getMonth().equals(month)) {
                testVals.add(users.getEntry(i));
            }
        }
        for (int i = 0; i < testVals.getLength(); i++) {
            for (int j = i + 1; j < testVals.getLength(); j++) {
                if (testVals.getEntry(i).getIndividualTradRate() < testVals
                    .getEntry(j).getIndividualTradRate()) {
                    User temp = testVals.getEntry(j);
                    testVals.replace(j, testVals.getEntry(i));
                    testVals.replace(i, temp);
                }
            }
        }
        return testVals; //displays original user data and doesnt make a new chain with new data
    }
    
    // ----------------------------------------------------------
    /**
     * Sort by Reach Month.
     * @param month
     * @return the new list
     */
    public DoublyLinkedList<User> sortByReachMonth(String month) {
        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        for (int i = 0; i < users.getLength(); i++) {
            if (users.getEntry(i).getMonth().equals(month)) {
                testVals.add(users.getEntry(i));
            }
        }
        for (int i = 0; i < testVals.getLength(); i++) {
            for (int j = i + 1; j < testVals.getLength(); j++) {
                if (testVals.getEntry(i).getIndividualReachRate() < testVals
                    .getEntry(j).getIndividualReachRate()) {
                    User temp = testVals.getEntry(j);
                    testVals.replace(j, testVals.getEntry(i));
                    testVals.replace(i, temp);
                }
            }
        }
        return testVals;
    }
    
  
}
