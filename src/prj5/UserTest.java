package prj5;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the User class for faults.
 * 
 * @author naren
 * @version Nov 16, 2023
 */
public class UserTest
    extends TestCase
{
    // ~ Fields ................................................................
    private User newUser;
    private User newUser2;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Sets up the test values.
     */
    public void setUp()
    {
        newUser = new User(
            "February",
            "narnarnoscoper",
            "NarenDaBeast",
            "India",
            "Cars",
            1011,
            35,
            100987,
            53809,
            29492);
        newUser2 = new User(
            "February",
            "jchen",
            "JoeyDAMonster",
            "China",
            "Cars",
            1011,
            35,
            100987,
            53809,
            29492);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getMonth method.
     */
    public void testGetMonth()
    {
        assertEquals(newUser.getMonth(), "February");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getUsername() method.
     */
    public void testGetUsername()
    {
        assertEquals(newUser.getUsername(), "narnarnoscoper");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getChannelName() method.
     */
    public void testGetChannelName()
    {
        assertEquals(newUser.getChannelName(), "NarenDaBeast");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getCountry() method.
     */
    public void testGetCountry()
    {
        assertEquals(newUser.getCountry(), "India");
    }


    // ----------------------------------------------------------
    /**
     * Tests the getMainTopic() method.
     */
    public void testGetMainTopic()
    {
        assertEquals(newUser.getMainTopic(), "Cars");
    }


    // ----------------------------------------------------------
    /**
     * tests the getLikes() method.
     */
    public void testGetLikes()
    {
        assertEquals(newUser.getLikes(), 1011);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getPosts() method.
     */
    public void testGetPosts()
    {
        assertEquals(newUser.getPosts(), 35);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getFollowers() method.
     */
    public void testGetFollowers()
    {
        assertEquals(newUser.getFollowers(), 100987);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getComments() method.
     */
    public void testGetComments()
    {
        assertEquals(newUser.getComments(), 53809);
    }


    // ----------------------------------------------------------
    /**
     * Tests the getViews() methods.
     */
    public void testGetViews()
    {
        assertEquals(newUser.getViews(), 29492);
    }


    // ----------------------------------------------------------
    /**
     * Tests the setLikes() method.
     */
    public void testSetLikes()
    {
        newUser.setLikes(1000);
        assertEquals(newUser.getLikes(), 1000);
    }


    // ----------------------------------------------------------
    /**
     * Tests the setComments() method.
     */
    public void testSetComments()
    {
        newUser.setComments(9876);
        assertEquals(newUser.getComments(), 9876);
    }


    // ----------------------------------------------------------
    /**
     * tests the setViews() method.
     */
    public void testSetViews()
    {
        newUser.setViews(100);
        assertEquals(newUser.getViews(), 100);
    }


    // ----------------------------------------------------------
    /**
     * Tests the setFollowers() method.
     */
    public void testSetFollowers()
    {
        newUser.setFollowers(8732);
        assertEquals(newUser.getFollowers(), 8732);
    }


    // ----------------------------------------------------------
    /**
     * tests the compareTo(0 method.
     */
    public void testCompareTo()
    {
        assertTrue(newUser.compareTo(newUser2) > 0);
    }


    // ----------------------------------------------------------
    /**
     * Tests the toString() method.
     */
    public void testToString()
    {
        assertEquals(
            newUser.toString(),
            "February, narnarnoscoper, NarenDaBeast, India, Cars,"
                + " 1011, 35, 100987, 53809, 29492");
    }
}
