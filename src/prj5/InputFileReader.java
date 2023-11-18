package prj5;

import java.util.Scanner;

import student.IOHelper;

/**
 * // -------------------------------------------------------------------------
 * /**
 * parses the input data from given files
 * 
 * @author 14342
 * @version Nov 16, 2023
 */
public class InputFileReader {
    // ~ Fields ................................................................
    @SuppressWarnings("unused")
    private DoublyLinkedList<User> dLList;
    private SortingCalculator newTemp = new SortingCalculator(dLList);
    // ~ Constructors ..........................................................
    /**
     * creates a new InputFileReader object
     * 
     * @param input
     *            the input file
     */
    public InputFileReader(String input) {
        dLList = readUserFile(input);
        //SortingCalculator newCalc = new SortingCalculator(dLList);
        //this.output();
    }


    // ~Public Methods ........................................................
    /**
     * helper method that will be used in the constructor
     * 
     * @param file
     *            the given file
     * @return DoublyLinkedList<User> which 
     */
    public DoublyLinkedList<User> readUserFile(String file) {
        Scanner inStream = IOHelper.createScanner(file);
        inStream.nextLine();// skip header
        DoublyLinkedList<User> list = new DoublyLinkedList<User>();
        while (inStream.hasNextLine()) {
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

            User newUser = new User(month, username, channel, country,
                mainTopic, likes, posts, followers, comments, views);
            if (isAMonth(month) && validNumberValues(followers, likes, comments,
                posts, views)) {
                list.add(newUser);
            }
        }
        return list;
    }


    /**
     * helper method for the readUserFile method
     */
    private int toInt(String str) {
        try {
            return Integer.parseInt(str);
        }
        catch (Exception e) {
            return 0;
        }
    }


    /**
     * helper method for readUserFile
     * 
     * @param month
     *            the string we are checking for a month
     */
    private boolean isAMonth(String month) {
        if (month.equals("January") || month.equals("February") || month.equals(
            "March") || month.equals("April") || month.equals("May") || month
                .equals("June") || month.equals("July") || month.equals(
                    "August") || month.equals("September") || month.equals(
                        "October") || month.equals("November") || month.equals(
                            "December")) {
            return true;
        }
        return false;
    }


    /**
     * helper method for readUserFile method
     * 
     * @param f
     *            follower count
     * @param l
     *            like count
     * @param c
     *            comments
     * @param p
     *            posts
     * @param v
     *            views
     * @return whether they are valid values
     */
    private boolean validNumberValues(int f, int l, int c, int p, int v) {
        if (f < 0 || l < 0 || c < 0 || p < 0 || v < 0) {
            return false;
        }
        return true;
    }
    /**
     * Outputs the value.
     */
    
    /*
    private void output() {
        DoublyLinkedList<User> newList = newTemp.sortByName();
        DoublyLinkedList<User> newList2 = newTemp.sortByReachRate();
        for(int i = 0; i < newList.getLength(); i++) {
            System.out.println(newList.getEntry(i).getChannelName());
            System.out.println("traditional: " + newTemp.getTraditionalRate(newList.getEntry(i)));
            System.out.println("==========");
            if(i == newList.getLength() - 1) {
                System.out.println("**********");
                System.out.println("**********");
            }
        }
        for(int j = 0; j < newList2.getLength(); j++) {
            System.out.println(newList.getEntry(j).getChannelName());
            System.out.println("reach: " + newTemp.getTraditionalRate(newList.getEntry(j)));
            System.out.println("==========");
        }
        
    }
    */

}
