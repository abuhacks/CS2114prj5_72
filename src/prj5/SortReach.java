package prj5;
import java.util.Comparator;
// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author jchen
 * @version Nov 28, 2023
 */
public class SortReach
    implements Comparator<User>
{
    @Override
    public int compare(User one, User two)
    {
        if (one.getFollowers() == 0 && two.getFollowers() > 0)
        {
            return -1;
        }
        if (one.getFollowers() > 0 && two.getFollowers() == 0)
        {
            return 1;
        }
        if (one.getFollowers() == 0 && two.getFollowers() == 0)
        {
            return 0;
        }
        int reachOne =
            ((one.getComments() + one.getLikes()) / one.getFollowers());
        int reachTwo =
            ((two.getComments() + two.getLikes()) / two.getFollowers());
        return Integer.compare(reachOne, reachTwo);
    }
}
