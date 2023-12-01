package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * * This is the class that is used to sort User objects by channel name,
 * alphabetically, through using a comparator.
 * 
 * @author jchen
 * @version Nov 28, 2023
 */
public class SortAlphabetically
    implements Comparator<User>
{
    @Override
    public int compare(User one, User two)
    {
        return one.getChannelName().compareTo(two.getChannelName());
    }
}
