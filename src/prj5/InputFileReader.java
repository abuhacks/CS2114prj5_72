package prj5;
//Virginia Tech Honor Code Pledge:
//
//As a Hokie, I will conduct myself with honor and integrity at all times.
//I will not lie, cheat, or steal, nor will I
//accept the actions of those who do.
//-- Naren Dawar(naren)(906615413), Joey Chen (PID), Abiel (PID), Adam (PID)
import java.util.Scanner;

import student.IOHelper;

/**
 * // -------------------------------------------------------------------------
 * /** Parses through a file and retrieves information that is then put inside
 * the code and is displayed in the GUI.
 * 
 * @author 14342
 * @version Nov 16, 2023
 */
public class InputFileReader
{
    // ~ Fields ................................................................
    @SuppressWarnings("unused")
    private DoublyLinkedList<User> dLList;

    // ~ Constructors ..........................................................
    /**
     * Creates a new InputFileReader object to read.
     * 
     * @param input
     *            the input file
     */
    public InputFileReader(String input)
    {
        dLList = readUserFile(input);
        // SortingCalculator newCalc = new SortingCalculator(dLList);
        // this.output();
    }


    // ~Public Methods ........................................................
    /**
     * Reads all necessary information within a csv on each line and creates
     * a new user with this information.
     * 
     * @param file 
     *            the given file to be read for data.
     * @return DoublyLinkedList<User> of users that can be manipulated.
     */
    public DoublyLinkedList<User> readUserFile(String file)
    {
        Scanner inStream = IOHelper.createScanner(file);
        inStream.nextLine();// skip header
        DoublyLinkedList<User> list = new DoublyLinkedList<User>();
        while (inStream.hasNextLine())
        {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            String month = values[0];
            String username = values[1];
            String channel = values[2];
            String country = values[3];
            String mainTopic = values[4];
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);

            User newUser = new User(
                month,
                username,
                channel,
                country,
                mainTopic,
                likes,
                posts,
                followers,
                comments,
                views);
            if (isFirstQuarter(month)
                && validNumberValues(followers, likes, comments, posts, views))
            {
                list.add(newUser);
            }
        }
        return list;
    }


    /**
     * Converts strings to ints when needed (e.g. "1" to 1).
     * @return the new integer from the string.
     */
    private int toInt(String str)
    {
        try
        {
            return Integer.parseInt(str);
        }
        catch (Exception e)
        {
            return 0;
        }
    }


    /**
     * Checks if months are within the allowed months
     * for the first quarter, if not they are disregarded.
     * 
     * @param month
     *            the string month to be checked.
     */
    private boolean isFirstQuarter(String month)
    {
        if (month.equals("January") || month.equals("February")
            || month.equals("March"))
        {
            return true;
        }
        return false;
    }


    /**
     * Verifies that all numbers/counts are valid and mathematically possible.
     * 
     * @param f
     *            the follower count
     * @param l
     *            the like count
     * @param c
     *            the number of comments
     * @param p
     *            number of posts
     * @param v
     *            number of views
     * @return a boolean based on whether all values are valid or not.
     */
    private boolean validNumberValues(int f, int l, int c, int p, int v)
    {
        if (f < 0 || l < 0 || c < 0 || p < 0 || v < 0)
        {
            return false;
        }
        return true;
    }


    /**
     * Outputs the current list.
     * 
     * @return the DoublyLinkedList.
     */

    public DoublyLinkedList<User> getList()
    {
        return dLList;
    }

}
