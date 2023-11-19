package prj5;
import java.util.Comparator;
public class CompareByName implements Comparable<User>
{

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param a the first user
     * @param b the second user
     * @return the int representation
     */
    public int compare(User a, User b)
    {
        return (a.getChannelName().compareTo(b.getChannelName()));
    }
    //~ Fields ................................................................

    @Override
    public int compareTo(User o)
    {
        return 20;
    }

    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

}
