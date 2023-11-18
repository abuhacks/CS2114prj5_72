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
public class SortingCalculator
{

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
    public SortingCalculator(DoublyLinkedList<User> users2)
    {
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
    public void addToList(User user)
    {
        users.add(user);
    }


    // ----------------------------------------------------------
    /**
     * gets the list.
     * 
     * @return the full list.
     */
    public DoublyLinkedList<User> getList()
    {
        return users;
    }


    // ----------------------------------------------------------
    /**
     * Sorts the linked list by name.
     * 
     * @return the sorted list.
     */
    public DoublyLinkedList<User> sortByName()
    {

        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        DoublyLinkedList<String> names = new DoublyLinkedList<String>();
        int index = 0;
        names.add(users.getEntry(0).getChannelName());
        for (int i = 1; i < users.getLength(); i++)
        {
            for (int j = 0; j < names.getLength(); j++)
            {
                if (names.getEntry(j)
                    .equals(users.getEntry(i).getChannelName()))
                {
                    continue;
                }
                else if (!names.getEntry(j)
                    .equals(users.getEntry(i).getChannelName())
                    && !names.contains(users.getEntry(i).getChannelName()))
                    names.add(index, users.getEntry(i).getChannelName());
                index++;
                testVals.add(users.getEntry(i));
            }
        }

        for (int i = 0; i < testVals.getLength() - 1; i++)
        {
            if (users.getEntry(i).compareTo(users.getEntry(i + 1)) > 0)
            {
                User temp = users.getEntry(i);
                users.replace(i, users.getEntry(i + 1));
                users.replace(i + 1, temp);
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
    public double getTraditionalRate(User user3)
    {
        Map<String, Integer> newMap = new HashMap<String, Integer>();
        newMap.put("January", 1);
        newMap.put("February", 2);
        newMap.put("March", 3);
        newMap.put("April", 4);
        User temp = user3;
        for (int i = 0; i < users.getLength(); i++)
        {
            if (users.getEntry(i).getChannelName()
                .equals(user3.getChannelName()) && users.getEntry(i) != user3)
            {
                user3.setComments(
                    user3.getComments() + users.getEntry(i).getComments());
                user3.setLikes(user3.getLikes() + users.getEntry(i).getLikes());
                if (newMap.get(users.getEntry(i).getMonth()) > newMap
                    .get(temp.getMonth()))
                {
                    temp = users.getEntry(i);
                }
            }

        }
        return ((user3.getComments() + user3.getLikes()) / temp.getFollowers())
            * 100;
    }


    // ----------------------------------------------------------
    /**
     * Gets the reach rate of a user.
     * 
     * @param user3
     * @return the reach rate.
     */
    public double getReachRate(User user3)
    {
        for (int i = 0; i < users.getLength(); i++)
        {
            if (users.getEntry(i).getChannelName()
                .equals(user3.getChannelName()) && users.getEntry(i) != user3)
            {
                user3.setComments(
                    user3.getComments() + users.getEntry(i).getComments());
                user3.setLikes(user3.getLikes() + users.getEntry(i).getLikes());
                user3.setFollowers(
                    user3.getFollowers() + users.getEntry(i).getFollowers());
            }
        }
        return ((user3.getComments() + user3.getLikes()) / user3.getViews())
            * 100;
    }


    // ----------------------------------------------------------
    /**
     * Returns a sorted linked list of the users.
     * 
     * @return a sorted linked list.
     */
    public DoublyLinkedList<User> sortByReachRate()
    {
        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        DoublyLinkedList<String> names = new DoublyLinkedList<String>();
        for (int i = 0; i < users.getLength(); i++)
        {
            if (names.contains((users.getEntry(i).getChannelName())))
            {
                continue;
            }
            names.add(users.getEntry(i).getChannelName());
            testVals.add(users.getEntry(i));
        }
        for (int i = 0; i < testVals.getLength(); i++)
        {
            for (int j = i + 1; j < testVals.getLength(); j++)
            {
                if (getReachRate(testVals.getEntry(i)) < getReachRate(
                    testVals.getEntry(j)))
                {
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
     * Sorts the data based on traditional rate.
     * 
     * @return the sorted list.
     */
    public DoublyLinkedList<User> sortByTraditionalRate()
    {
        DoublyLinkedList<User> testVals = new DoublyLinkedList<User>();
        DoublyLinkedList<String> names = new DoublyLinkedList<String>();
        for (int i = 0; i < users.getLength(); i++)
        {
            if (names.contains((users.getEntry(i).getChannelName())))
            {
                continue;
            }
            names.add(users.getEntry(i).getChannelName());
            testVals.add(users.getEntry(i));
        }
        for (int i = 0; i < testVals.getLength(); i++)
        {
            for (int j = i + 1; j < testVals.getLength(); j++)
            {
                if (getTraditionalRate(
                    testVals.getEntry(i)) < getTraditionalRate(
                        testVals.getEntry(j)))
                {
                    User temp = testVals.getEntry(i);
                    testVals.replace(i, testVals.getEntry(j));
                    testVals.replace(j, temp);
                }
            }

        }
        return testVals;
    }
}
