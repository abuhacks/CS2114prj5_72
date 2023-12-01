package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Naren Dawar(naren)(906615413), Joey Chen (PID), Abiel (PID), Adam (PID)
import java.util.HashMap;
import java.util.Map;

// -------------------------------------------------------------------------
/**
 * Used for sorting the information into desired new lists that can be used for
 * display.
 * All sort or get methods remove duplicates but still have full functionality
 * logistically and in actuality.
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
     * Gets the doubly linked list.
     * 
     * @return the full list.
     */
    public DoublyLinkedList<User> getList() {
        return users;
    }


    // ----------------------------------------------------------
    /**
     * Returns the users (removes duplicates).
     * 
     * @return the users.
     * 
     */
    public DoublyLinkedList<User> getUsers() {
        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        DoublyLinkedList<String> names = new DoublyLinkedList<String>();
        for (int i = 0; i < users.getLength(); i++) {
            if (names.contains((users.getEntry(i).getChannelName()))) {
                continue;
            }
            names.add(users.getEntry(i).getChannelName());
            testVals.add(users.getEntry(i));
        }
        return testVals;
    }


    // ----------------------------------------------------------
    /**
     * Sorts the linked list by name (removes all duplicates).
     * 
     * @return the sorted list.
     */

    public DoublyLinkedList<User> sortByName() {

        DoublyLinkedList<User> testVals = this.getUsers();

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
     * Gets the traditional rate of a user for the first quarter.
     * 
     * @param user3
     *            user to be checked.
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
     * Gets the reach rate of a user for the first quarter.
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
     * Returns a linked list of the users sorted by reach rate for the first
     * quarter.
     * 
     * @return a sorted linked list.
     */
    public DoublyLinkedList<User> sortByReachRate() {
        DoublyLinkedList<User> testVals = this.getUsers();

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
     * Returns a linked list of the users sorted by traditional rate for the
     * first quarter.
     * 
     * @return the sorted list.
     */
    public DoublyLinkedList<User> sortByTraditionalRate() {
        DoublyLinkedList<User> testVals = this.getUsers();

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
     * Sorts the users based off a given month (uses data ONLY within the given
     * month).
     * 
     * @param month
     *            to be calculated for.
     * @return the new list with users from specified month.
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
                if (getIndividualTradRate(testVals.getEntry(
                    i)) < getIndividualTradRate(testVals.getEntry(j))) {
                    User temp = testVals.getEntry(j);
                    testVals.replace(j, testVals.getEntry(i));
                    testVals.replace(i, temp);
                }
            }
        }
        return testVals; // displays original user data and doesnt make a new
                         // chain with new data
    }


    // ----------------------------------------------------------
    /**
     * Sorts users based off reach rate for a given month by the user.
     * 
     * @param month
     *            to be calculated for.
     * @return the new list with users from specified month.
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
                if (getIndividualReachRate(testVals.getEntry(
                    i)) < getIndividualReachRate(testVals.getEntry(j))) {
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
     * Returns users based on input for month (NOT sorted).
     * 
     * @param month
     *            to return users for.
     * @return the new list based on month.
     */
    public DoublyLinkedList<User> getByMonth(String month) {
        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        for (int i = 0; i < users.getLength(); i++) {
            if (users.getEntry(i).getMonth().equals(month)) {
                testVals.add(users.getEntry(i));
            }
        }
        return testVals;
    }


    // ----------------------------------------------------------
    /**
     * Sorts users in a given month by channel name.
     * 
     * @param month
     *            to sort users by.
     * @return the new sorted list.
     */
    public DoublyLinkedList<User> sortByMonth(String month) {
        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        for (int i = 0; i < users.getLength(); i++) {
            if (users.getEntry(i).getMonth().equals(month)) {
                testVals.add(users.getEntry(i));
            }
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
     * Gets the individual reach rate for a specified user.
     * 
     * @param user
     *            to get the rate for.
     * 
     * @return reach rate for specified user.
     */
    public double getIndividualReachRate(User user) {
        return ((user.getComments() + user.getLikes()) / (double)user
            .getViews()) * 100;
    }


    // ----------------------------------------------------------
    /**
     * Gets the individual traditional rate for a specified user.
     * 
     * @param user
     *            to get the rate for.
     * 
     * @return the individual traditional rate for a specified user.
     */
    public double getIndividualTradRate(User user) {
        return ((user.getComments() + user.getLikes()) / (double)user
            .getFollowers()) * 100;
    }
}
