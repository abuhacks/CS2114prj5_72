package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * This is the class that is used to sort User objects by traditional rate
 * through using a comparator.
 * 
 * @author jchen
 * @version Nov 28, 2023
 */
public class SortTraditional
    implements Comparator<User>
{
    @Override
    public int compare(User one, User two)
    {
        return Double
            .compare(two.getIndividualTradRate(), one.getIndividualTradRate());
    }
}
