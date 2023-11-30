package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * This is the class that is used to sort User objects by reach rate through
 * using a comparator.
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
        if (one.getFollowers() < two.getFollowers())
        {
            return -1;
        }
        if (one.getFollowers() > two.getFollowers())
        {
            return 1;
        }
        
        if (one.getFollowers() == 0 && two.getFollowers() == 0)
        {
            return 0;
        }
        
        return Double.compare(
            two.getIndividualReachRate(),
            one.getIndividualReachRate());
    }
}
