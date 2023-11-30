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
public class SortTraditional
    implements Comparator<User>
{
    @Override
    public int compare(User one, User two)
    {
        if (one.getViews() == 0 && two.getViews() > 0)
        {
            return -1;
        }
        if (one.getViews() > 0 && two.getViews() == 0)
        {
            return 1;
        }
        if (one.getViews() == 0 && two.getViews() == 0)
        {
            return 0;
        }
        int traditionalOne =
            ((one.getComments() + one.getLikes()) / one.getViews());
        int traditionalTwo =
            ((two.getComments() + two.getLikes()) / two.getViews());
        return Integer.compare(traditionalOne, traditionalTwo);
    }
}