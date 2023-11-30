package prj5;
import java.util.Comparator;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author jchen
 *  @version Nov 28, 2023
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