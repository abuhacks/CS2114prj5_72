package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This is the test class for DoublyLinkedList class and its methods.
 * 
 * @author jchen
 * @version Nov 15, 2023
 */
public class DoublyLinkedListTest
    extends TestCase
{
    // ~ Fields ................................................................
    private DoublyLinkedList<String> list;

    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * This method sets up the test cases for the test methods.
     */
    public void setUp()
    {
        list = new DoublyLinkedList<String>();
    }


    // ----------------------------------------------------------
    /**
     * This method tests the add(T) method.
     */
    public void testAdd()
    {
        list.add("Chicken1");
        assertEquals("Chicken1", list.getEntry(0));
        list.add("Chicken2");
        list.add("Chicken3");
        list.add("Chicken4");
        assertEquals("Chicken2", list.getEntry(1));
        assertEquals("Chicken3", list.getEntry(2));

    }


    // ----------------------------------------------------------
    /**
     * This method tests the add(int, T) method. 
     */
    public void testAddIndex()
    {
        list.add(0, "Chicken1");
        assertEquals("Chicken1", list.getEntry(0));
        list.add(0, "Chicken2");
        assertEquals("Chicken2", list.getEntry(1));
        list.add(0,"Chicken1.5");
        assertEquals(3, list.getLength());
       
        assertEquals("Chicken1.5", list.getEntry(1));
        Exception exc = null;
        try {
            list.add(4, "Chicken3");
        }
        catch(Exception e) {
            exc = e;
        }
        assertTrue(exc instanceof IndexOutOfBoundsException);
        
    }
    // ----------------------------------------------------------
    /**
     * This method tests the clear() method. 
     */
    public void testClear() {
        list.clear();
        assertEquals(0, list.getLength());
        list.add("Chicken");
        list.add("Chicken");
        list.add("Chicken"); 
        assertEquals(3, list.getLength());
        list.clear();
        assertEquals(0, list.getLength());
    }
    // ----------------------------------------------------------
    /**
     * This method tests the contains() method. 
     */
    public void testContains() {
        assertFalse(list.contains("chicken"));
        list.add("chicken1");
        list.add("chicken2");
        list.add("chicken3");
        assertTrue(list.contains("chicken1"));
        assertTrue(list.contains("chicken2"));
        assertTrue(list.contains("chicken3"));
        assertFalse(list.contains("chicken"));
    }

}
