// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Naren Dawar(906615413), Joey Chen (906610199),
// -- Abiel (906540750), Adam (906552490)
package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Sorting test class to test the sorting calcualtor.
 * 
 * @author naren
 * @version Nov 16, 2023
 */
public class SortingCalculatorTest extends TestCase {
    // ~ Fields ................................................................
    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private User user5;
    private User user6;
    private DoublyLinkedList<User> theList;
    private SortingCalculator calculator;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Tests the setUp() method.
     */
    public void setUp() {
        user1 = new User("February", "narnarnoscoper", "NarenDaBeast", "India",
            "Cars", 1, 1, 1, 1, 1);
        user2 = new User("February", "jchen", "JoeyCHEN", "China", "Cars", 10,
            10, 1, 10, 10);
        user3 = new User("February", "Miggy", "MiggyMagtoto", "Taiwan", "Cars",
            20, 20, 1, 20, 20);
        user4 = new User("March", "narnarnoscoper", "NarenDaBeast", "India",
            "Cars", 1, 1, 1, 1, 1);
        user5 = new User("March", "jchen", "JoeyCHEN", "China", "Cars", 10, 10,
            1, 10, 10);
        user6 = new User("March", "Miggy", "MiggyMagtoto", "Taiwan", "Cars", 17,
            20, 1, 20, 20);
        theList = new DoublyLinkedList<User>();
        theList.add(user1);
        theList.add(user2);
        theList.add(user3);
        theList.add(user4);
        theList.add(user5);
        theList.add(user6);
        calculator = new SortingCalculator(theList);
    }

    // ----------------------------------------------------------


    // ----------------------------------------------------------
    /**
     * Tests getting the list.
     */
    public void testGetList() {
        assertEquals(calculator.getList(), theList);
        theList.add(user4);
        theList.add(user5);
        theList.add(user6);
        assertEquals(calculator.getList(), theList);
    }


    // ----------------------------------------------------------
    /**
     * Tests the sortByName() method.
     */

    public void testSortByName() {
        DoublyLinkedList<User> testing = new DoublyLinkedList<User>();
        testing.add(user2);
        testing.add(user3);
        testing.add(user1);
        assertEquals(calculator.sortByName(), testing);
    }


    /**
     * Tests the sortByReach() method.
     */
    public void testSortByReachRate() {
        DoublyLinkedList<User> newList2 = new DoublyLinkedList<User>();
        newList2.add(user3);
        newList2.add(user2);
        newList2.add(user1);
        assertEquals(calculator.sortByReachRate().getEntry(0).getChannelName(),
            "NarenDaBeast");
        assertEquals(calculator.sortByReachRate().getEntry(1).getChannelName(),
            "JoeyCHEN");
        assertEquals(calculator.sortByReachRate().getEntry(2).getChannelName(),
            "MiggyMagtoto");

    }


    // ----------------------------------------------------------
    /**
     * Tests the traditional rate.
     */
    public void testSortByTraditionalRate() {
        DoublyLinkedList<User> newList2 = new DoublyLinkedList<User>();
        newList2.add(user3);
        newList2.add(user2);
        newList2.add(user1);
        assertEquals(calculator.sortByTraditionalRate().getEntry(0)
            .getChannelName(), "MiggyMagtoto");
        assertEquals(calculator.sortByTraditionalRate().getEntry(1)
            .getChannelName(), "JoeyCHEN");
        assertEquals(calculator.sortByTraditionalRate().getEntry(2)
            .getChannelName(), "NarenDaBeast");
        newList2.add(user4);
        newList2.add(user5);
        newList2.add(user6);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getUsers() method.
     */
    public void testGetUsers() {
        DoublyLinkedList<User> newList = new DoublyLinkedList<User>();
        newList.add(user1);
        newList.add(user2);
        newList.add(user3);
        assertEquals(calculator.getUsers(), newList);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getTraditionalRate() method.
     */
    public void testgetTraditionalRate() {
        assertEquals(calculator.getTraditionalRate(user1), 400.00, 0.1);
        assertEquals(calculator.getTraditionalRate(user2), 4000.00, 0.1);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getReachRate() method.
     */
    public void testgetReachRate() {
        assertEquals(calculator.getReachRate(user1), 200.00, 0.1);
        assertEquals(calculator.getReachRate(user2), 200.00, 0.1);
    }


    // ----------------------------------------------------------
    /**
     * Tests the sortByTradMonth() method.
     */
    public void testSortByTradMonth() {
        DoublyLinkedList<User> list2 = new DoublyLinkedList<User>();
        list2.add(user3);
        list2.add(user2);
        list2.add(user1);
        assertEquals(calculator.sortByTradMonth("February"), list2);
    }


    // ----------------------------------------------------------
    /**
     * Tests the sortByReachMonth() method.
     */
    public void testSortByReachMonth() {
        DoublyLinkedList<User> list2 = new DoublyLinkedList<User>();
        list2.add(user3);
        list2.add(user2);
        list2.add(user1);
        assertEquals(calculator.sortByReachMonth("February"), list2);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getByMonth() method.
     */
    public void testgetByMonth() {
        DoublyLinkedList<User> list2 = new DoublyLinkedList<User>();
        list2.add(user1);
        list2.add(user2);
        list2.add(user3);
        assertEquals(calculator.getByMonth("February"), list2);
    }


    // ----------------------------------------------------------
    /**
     * Tests the sortByMonth() method.
     */
    public void testsortByMonth() {
        DoublyLinkedList<User> list2 = new DoublyLinkedList<User>();
        list2.add(user2);
        list2.add(user3);
        list2.add(user1);
        assertEquals(calculator.sortByMonth("February"), list2);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getIndividualReachRate() method.
     */
    public void testGetIndividualReachRate() {
        assertEquals(calculator.getIndividualReachRate(user1), 200.0, 0.1);
        assertEquals(calculator.getIndividualReachRate(user2), 200.0, 0.1);
        assertEquals(calculator.getIndividualReachRate(user3), 200.0, 0.1);
        assertEquals(calculator.getIndividualReachRate(user4), 200.0, 0.1);
        assertEquals(calculator.getIndividualReachRate(user5), 200.0, 0.1);
        assertEquals(calculator.getIndividualReachRate(user6), 185.0, 0.1);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getIndividualTradRate() method.
     */
    public void testGetIndividualTradRate() {
        assertEquals(calculator.getIndividualTradRate(user1), 200.0, 0.1);
        assertEquals(calculator.getIndividualTradRate(user2), 2000.0, 0.1);
        assertEquals(calculator.getIndividualTradRate(user3), 4000.0, 0.1);
    }

}
