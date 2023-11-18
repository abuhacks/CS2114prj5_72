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
        assertEquals(2, list.getLength());
        assertEquals("Chicken2", list.getEntry(0));
        list.add(1, "Chicken3");
        assertEquals(3, list.getLength());
        list.add(1, "Chicken2.5");
        assertEquals(4, list.getLength());
        assertEquals("Chicken2.5", list.getEntry(1));
        list.add(0, "Chicken1.0");
        assertEquals(5, list.getLength());
        list.add(5, "Chicken6");
        Exception exc = null;
        try
        {
            list.add(7, "Chicken3");
        }
        catch (Exception e)
        {
            exc = e;
        }
        assertTrue(exc instanceof IndexOutOfBoundsException);
        try
        {
            list.add(-1, "Chicken3");
        }
        catch (Exception e)
        {
            exc = e;
        }
        assertTrue(exc instanceof IndexOutOfBoundsException);
    }


    // ----------------------------------------------------------
    /**
     * This method tests the clear() method.
     */
    public void testClear()
    {
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
    public void testContains()
    {
        assertFalse(list.contains("chicken"));
        list.add("chicken1");
        list.add("chicken2");
        list.add("chicken3");
        assertTrue(list.contains("chicken1"));
        assertTrue(list.contains("chicken2"));
        assertTrue(list.contains("chicken3"));
        assertFalse(list.contains("chicken"));
    }


    // ----------------------------------------------------------
    /**
     * This method tests the getEntry() method.
     */
    public void testGetEntry()
    {
        Exception exc = null;
        try {
            list.getEntry(0);
        }
        catch(Exception e) {
            exc = e;
        }
        assertTrue(exc instanceof IndexOutOfBoundsException);
       
        list.add("chicken");
        try {
            list.getEntry(2);
        }
        catch(Exception e) {
            exc = e;
        }
        assertTrue(exc instanceof IndexOutOfBoundsException);
        try {
            list.getEntry(-1);
        }
        catch(Exception e) {
            exc = e;
        }
        assertTrue(exc instanceof IndexOutOfBoundsException);
        
        list.add("chicken2");
        list.add("chicken3");
        list.add("chicken4");
        assertEquals("chicken", list.getEntry(0));
        assertEquals("chicken2", list.getEntry(1));
        assertEquals("chicken3", list.getEntry(2));
        assertEquals("chicken4", list.getEntry(3));
        
    }


    // ----------------------------------------------------------
    /**
     * This method tests the getLength() method.
     */
    public void testGetLength()
    {

    }


    // ----------------------------------------------------------
    /**
     * This method tests the isEmpty() method.
     */
    public void testIsEmpty()
    {

    }


    // ----------------------------------------------------------
    /**
     * This method tests the remove() method.
     */
    public void testRemove()
    {
        Exception exc = null;
        try
        {
            list.remove(1);
        }
        catch (Exception e)
        {
            exc = e;
        }
        assertTrue(exc instanceof IndexOutOfBoundsException);
        try
        {
            list.remove(-1);
        }
        catch (Exception e)
        {
            exc = e;
        }
        assertTrue(exc instanceof IndexOutOfBoundsException);

        list.add("chicken1");
        list.add("chicken1");
        list.add("chicken3");
        assertEquals("chicken1", list.remove(0));
        assertEquals("chicken3", list.remove(1));
        list.add("chicken2");
        list.add("chicken3");
        list.add("chicken4");
        list.add("chicken5");
        assertEquals("chicken3", list.remove(2));
        assertEquals(4, list.getLength());
        assertEquals("chicken1", list.remove(0));
    }


    // ----------------------------------------------------------
    /**
     * This method tests the replace() method.
     */
    public void testReplace()
    {
        Exception exc = null;
        try
        {
            list.replace(1, "chicken");
        }
        catch (Exception e)
        {
            exc = e;
        }
        assertTrue(exc instanceof IndexOutOfBoundsException);
        try
        {
            list.replace(-1, "chicken");
        }
        catch (Exception e)
        {
            exc = e;
        }
        assertTrue(exc instanceof IndexOutOfBoundsException);
        list.add("chicken1");
        list.add("chicken2");
        list.add("chicken3");
        list.add("chicken4");
        list.add("chicken5");
        assertEquals("chicken1", list.replace(0, "beef1"));
        assertEquals("chicken2", list.replace(1, "beef2"));
        assertEquals("chicken3", list.replace(2, "beef3"));
        assertEquals("chicken4", list.replace(3, "beef4"));
        assertEquals("chicken5", list.replace(4, "beef5"));
    }


    // ----------------------------------------------------------
    /**
     * This method tests the toArray() method.
     */
    public void testToArray()
    {
        list.add("chicken1");
        list.add("chicken2");
        list.add("chicken3");
        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertEquals("chicken1", array[0]);
        assertEquals("chicken2", array[1]);
        assertEquals("chicken3", array[2]);
    }


    // ----------------------------------------------------------
    /**
     * This method tests the toString() method.
     */
    public void testToString()
    {
        assertEquals("{}", list.toString());
        list.add("chicken");
        assertEquals("{chicken}", list.toString());
        list.add("chicken2");
        list.add("chicken3");
        assertEquals("{chicken, chicken2, chicken3}", list.toString());
    }


    // ----------------------------------------------------------
    /**
     * This method tests the equals() method.
     */
    @SuppressWarnings("unlikely-arg-type")
    public void testEquals()
    {
        DoublyLinkedList<String> list2 = new DoublyLinkedList<String>();
        list.add("chicken");
        list2.add("chicken");
        assertTrue(list.equals(list2));
        assertTrue(list.equals(list));
        assertFalse(list.equals(null));
        list2.add("chicken");
        assertFalse(list.equals(list2));
        list.add("beef");
        assertFalse(list.equals(list2));
        assertFalse(list.equals(1));
    }


    // ----------------------------------------------------------
    /**
     * This method tests the compareTo() method.
     */
    public void testCompareTo()
    {
       
    }

}
