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
        //empty
    }
    //~Public  Methods ........................................................
    /**
     * helper method that will be used in the constructor
     * @param file the given file
     */
    private DoublyLinkedList<User> readUserFile(String file)
    {
        Scanner inStream = IOHelper.createScanner(<String file name>);
        inStream.nextLine();// skip header
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


            // TODO : Populate the Classes created to store the data


    }
}
