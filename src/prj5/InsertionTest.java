package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author jchen
 * @version Nov 30, 2023
 */
public class InsertionTest
    extends TestCase
{
    // ~ Fields ................................................................
    private DoublyLinkedList<User> list;

    // ~Public Methods ........................................................
    public void setUp()
    {
        list = new DoublyLinkedList<User>();
        list.add(
            new User(
                "February",
                "narnarnoscoper",
                "2",
                "India",
                "Cars",
                0,
                35,
                1,
                2,
                1));
        list.add(
            new User(
                "February",
                "jchen",
                "3",
                "China",
                "Cars",
                0,
                35,
                1,
                3,
                1));
        list.add(
            new User(
                "March",
                "jchen",
                "1",
                "China",
                "Cars",
                0,
                35,
                1,
                1,
                1));
        list.add(
            new User(
                "March",
                "jchen",
                "5",
                "China",
                "Cars",
                0,
                35,
                1,
                5,
                1));
        list.add(
            new User(
                "March",
                "jchen",
                "4",
                "China",
                "Cars",
                0,
                35,
                1,
                4,
                1));
    }


    // ----------------------------------------------------------
    /**
     * tests sorting by reach rate for users 
     */
    public void testReach()
    {
        assertEquals(200, list.getEntry(0).getIndividualReachRate(), 0.1);
        assertEquals(300, list.getEntry(1).getIndividualReachRate(), 0.1);
        assertEquals(100, list.getEntry(2).getIndividualReachRate(), 0.1);
        assertEquals(500, list.getEntry(3).getIndividualReachRate(), 0.1);
        assertEquals(400, list.getEntry(4).getIndividualReachRate(), 0.1);
        list.insertionSort(new SortReach());
        assertEquals(500, list.getEntry(0).getIndividualReachRate(), 0.1);
        assertEquals(400, list.getEntry(1).getIndividualReachRate(), 0.1);
        assertEquals(300, list.getEntry(2).getIndividualReachRate(), 0.1);
        assertEquals(200, list.getEntry(3).getIndividualReachRate(), 0.1);
        assertEquals(100, list.getEntry(4).getIndividualReachRate(), 0.1);
        assertEquals(5, list.getLength());
        list.add(
            new User(
                "February",
                "jchen2",
                "7",
                "China",
                "Cars",
                0,
                35,
                1,
                7,
                1));
        assertEquals(6, list.getLength());
        //assertEquals(600, list.getEntry(5).getIndividualReachRate(), 0.1);
        list.add(
            new User(
                "February",
                "jchen",
                "6",
                "China",
                "Cars",
                0,
                35,
                1,
                6,
                1));
        assertEquals(7, list.getLength());
        assertEquals(600, list.getEntry(5).getIndividualReachRate(), 0.1);
        assertEquals(700, list.getEntry(4).getIndividualReachRate(), 0.1);
        list.insertionSort(new SortReach());
        
        assertEquals(700, list.getEntry(0).getIndividualReachRate(), 0.1);
        assertEquals(600, list.getEntry(1).getIndividualReachRate(), 0.1);
        assertEquals(500, list.getEntry(2).getIndividualReachRate(), 0.1);
        assertEquals(400, list.getEntry(3).getIndividualReachRate(), 0.1);
        assertEquals(300, list.getEntry(4).getIndividualReachRate(), 0.1);
        assertEquals(200, list.getEntry(5).getIndividualReachRate(), 0.1);
        assertEquals(100, list.getEntry(6).getIndividualReachRate(), 0.1);
    }
    // ----------------------------------------------------------
    /**
     * tests sorting by reach rate for users 
     */
    public void testTraditional()
    {
        assertEquals(200, list.getEntry(0).getIndividualTradRate(), 0.1);
        assertEquals(300, list.getEntry(1).getIndividualTradRate(), 0.1);
        assertEquals(100, list.getEntry(2).getIndividualTradRate(), 0.1);
        assertEquals(500, list.getEntry(3).getIndividualTradRate(), 0.1);
        assertEquals(400, list.getEntry(4).getIndividualTradRate(), 0.1);
        list.insertionSort(new SortReach());
        assertEquals(500, list.getEntry(0).getIndividualTradRate(), 0.1);
        assertEquals(400, list.getEntry(1).getIndividualTradRate(), 0.1);
        assertEquals(300, list.getEntry(2).getIndividualTradRate(), 0.1);
        assertEquals(200, list.getEntry(3).getIndividualTradRate(), 0.1);
        assertEquals(100, list.getEntry(4).getIndividualTradRate(), 0.1);
        list.add(
            new User(
                "February",
                "jchen2",
                "7",
                "China",
                "Cars",
                0,
                35,
                1,
                7,
                1));
        list.add(
            new User(
                "February",
                "jchen",
                "6",
                "China",
                "Cars",
                0,
                35,
                1,
                6,
                1));
        assertEquals(700, list.getEntry(5).getIndividualTradRate(), 0.1);
        assertEquals(600, list.getEntry(6).getIndividualTradRate(), 0.1);
        list.insertionSort(new SortReach());
        
        assertEquals(700, list.getEntry(0).getIndividualTradRate(), 0.1);
        assertEquals(600, list.getEntry(1).getIndividualTradRate(), 0.1);
        assertEquals(500, list.getEntry(2).getIndividualTradRate(), 0.1);
        assertEquals(400, list.getEntry(3).getIndividualTradRate(), 0.1);
        assertEquals(300, list.getEntry(4).getIndividualTradRate(), 0.1);
        assertEquals(200, list.getEntry(5).getIndividualTradRate(), 0.1);
        assertEquals(100, list.getEntry(6).getIndividualTradRate(), 0.1);
    }
}
