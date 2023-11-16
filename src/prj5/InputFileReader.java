package prj5;
/**
 * // -------------------------------------------------------------------------
/**
 *  parses the input data from given files
 * 
 *  @author 14342
 *  @version Nov 16, 2023
 */
public class InputFileReader
{
    //~ Fields ................................................................
    private DoublyLinkedList<User> dLList;
    //~ Constructors ..........................................................
    /**
     * creates a new InputFileReader object
     * @param input the input file
     */
    public InputFileReader(String input)
    {
        readUserFile(input);
    }
    //~Public  Methods ........................................................
    /**
     * helper method that will be used in the constructor
     * @param file the given file
     */
    private DoublyLinkedList<User> readUserFile(String file)
    {
        Scanner inStream = IOHelper.createScanner(file);
        inStream.nextLine();// skip header
        DoublyLinkedList<User> dLList = new DoublyLinkedList<User>();
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


            // TODO : Populate the Classes created to store the data
            //new dllist
            //new user with those fields
            User newUser = new User(month, username, channel, country, 
                mainTopic, likes, posts, followers, comments, views);
            if (isAMonth(month))
            {
                dLList.add(newUser);
            }
        }
        return dLList;
    }
    /**
     * helper method for the readUserFile method
     */
    private int toInt(String str)
    {
        try
        {
            return Integer.ParseInt(str);
        }
        catch(Exception e){
            return 0;
        }
    }
    /**
     * helper method for readUserFile
     * @param month the string we are checking for a month
     */
    private boolean isAMonth(String month)
    {
        if (month.equals("January") || month.equals("February") || 
            month.equals("March") || month.equals("April") ||
            month.equals("May") || month.equals("June") ||
            month.equals("July") || month.equals("August") ||
            month.equals("September") || month.equals("October") ||
            month.equals("November") || month.equals("December"))
        {
            return true
        }
        return false;
    }
}
