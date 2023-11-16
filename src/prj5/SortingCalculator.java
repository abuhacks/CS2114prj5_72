package prj5;
// -------------------------------------------------------------------------
/**
 *  Used for sorting the information based off certain values.
 * 
 *  @author naren
 *  @version Nov 12, 2023
 */
public class SortingCalculator
{

    //~ Fields ................................................................
    private DoublyLinkedList<User> users;
    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new SortingCalculator object.
     * @param users2 for the user to be;
     */
    public SortingCalculator(DoublyLinkedList<User> users2) {
        users = users2;
    }
    //~Public  Methods ........................................................
    // ----------------------------------------------------------
    /**
     * Returns the reach engagement rate for a user.
     * @param user to get rate from.
     * @return the reach by engagement rate
     */
    public double getReachEngagementRate(User user) {
        return (((user.getComments() + user.getLikes())/ user.getViews())) * .1;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns the traditional engagement rate.
     * @param user to get rate from.
     * @return the traditional rate.
     */
    public double getTraditionalEngagementRate(User user) {
        return ( (user.getComments() + user.getLikes())/ user.getFollowers()) * 100;
    }
    
    // ----------------------------------------------------------
    /**
     * Adds a user to the list.
     * @param user to be added
     */
    public void addToList(User user) {
        users.add(user);
    }
    
    // ----------------------------------------------------------
    /**
     * gets the list.
     * @return the full list.
     */
    public DoublyLinkedList<User> getList() {
        return users;
    }
    
    // ----------------------------------------------------------
    /**
     * Sorts the linked list by name.
     * @return the sorted list.
     */
    public DoublyLinkedList<User> sortByName() {
        return null;
    }
    
    
}
