// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Naren Dawar(906615413), Joey Chen (906610199),
// -- Abiel (906540750), Adam (906552490)
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
public class SortAlphabetically implements Comparator<User> {
    // ----------------------------------------------------------
    /**
     * This method takes two User objects as a parameter, and it takes the
     * channel name of each User and compares the two Strings.
     * 
     * @param one
     *            the first User object used to compare
     * @param two
     *            the second User object used to compare
     * @return 1 if one has a higher lexicographical order, -1 if two has a
     *         higher lexicographical order, 0 if same lexicographical
     *         rating
     */
    @Override
    public int compare(User one, User two) {
        return one.getChannelName().compareTo(two.getChannelName());
    }
}
