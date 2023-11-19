package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Sorting test class to test the sorting calcualtor.
 * 
 * @author naren
 * @version Nov 16, 2023
 */
public class SortingCalculatorTest
    extends TestCase
{
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
    public void setUp()
    {
        user1 = new User(
            "February",
            "narnarnoscoper",
            "NarenDaBeast",
            "India",
            "Cars",
            1,
            1,
            1,
            1,
            1);
        user2 = new User(
            "February",
            "jchen",
            "JoeyCHEN",
            "China",
            "Cars",
            10,
            10,
            1,
            10,
            10);
        user3 = new User(
            "February",
            "Miggy",
            "MiggyMagtoto",
            "Taiwan",
            "Cars",
            20,
            20,
            1,
            20,
            20);
        user4 = new User(
            "March",
            "narnarnoscoper",
            "NarenDaBeast",
            "India",
            "Cars",
            1,
            1,
            1,
            1,
            1);
        user5 = new User(
            "March",
            "jchen",
            "JoeyCHEN",
            "China",
            "Cars",
            10,
            10,
            1,
            10,
            10);
        user6 = new User(
            "March",
            "Miggy",
            "MiggyMagtoto",
            "Taiwan",
            "Cars",
            20,
            20,
            1,
            20,
            20);
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
    /**
     * Tests the addToList() method.
     */
    public void testAddToList()
    {
        User user7 = new User(
            "March",
            "EdwardY",
            "TheEdward",
            "Taiwan",
            "Cars",
            1011,
            432,
            3434,
            43,
            20);
        calculator.addToList(user7);
        assertTrue(theList.contains(user7));
        DoublyLinkedList<User> testCase = new DoublyLinkedList<User>();
        testCase.add(user4);
        testCase.add(user5);
        testCase.add(user6);
        assertTrue(testCase.contains(user4));
        assertTrue(testCase.contains(user5));
        assertTrue(testCase.contains(user6));
    }


    // ----------------------------------------------------------
    /**
     * Tests getting the list.
     */
    public void testGetList()
    {
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

    public void testSortByName()
    {
        DoublyLinkedList<User> testing = new DoublyLinkedList<User>();
        testing.add(user2);
        testing.add(user3);
        testing.add(user1);
        assertEquals(calculator.sortByName(), testing);
    }

    /**
     * Tests the sortByReach() method.
     */
    public void testSortByReachRate()
    {
        DoublyLinkedList<User> newList2 = new DoublyLinkedList<User>();
        newList2.add(user3);
        newList2.add(user2);
        newList2.add(user1);
        assertEquals(
            calculator.sortByReachRate().getEntry(0).getChannelName(),
            "NarenDaBeast");
        assertEquals(
            calculator.sortByReachRate().getEntry(1).getChannelName(),
            "JoeyCHEN");
        assertEquals(
            calculator.sortByReachRate().getEntry(2).getChannelName(),
            "MiggyMagtoto");
    }


    // ----------------------------------------------------------
    /**
     * Tests the traditional rate.
     */
    public void testSortByTraditionalRate()
    {
        DoublyLinkedList<User> newList2 = new DoublyLinkedList<User>();
        newList2.add(user3);
        newList2.add(user2);
        newList2.add(user1);
        assertEquals(
            calculator.sortByTraditionalRate().getEntry(0).getChannelName(),
            "MiggyMagtoto");
        assertEquals(
            calculator.sortByTraditionalRate().getEntry(1).getChannelName(),
            "MiggyMagtoto");
        assertEquals(
            calculator.sortByTraditionalRate().getEntry(2).getChannelName(),
            "NarenDaBeast");
        newList2.add(user4);
        newList2.add(user5);
        newList2.add(user6);
    }
}
