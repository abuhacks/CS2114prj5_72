package prj5;

// -------------------------------------------------------------------------
/**
 * Represents a user that will be broken down into many parts.
 * 
 * @author naren
 * @version Nov 12, 2023
 */
public class User
    implements Comparable<User>
{
    // ~ Fields ................................................................
    private String username;
    private String country;
    private String mainTopic;
    private int followers;
    private int likes;
    private int comments;
    private int posts;
    private int views;
    private String channelName;
    private String month;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new User object.
     * 
     * @param month1
     *            for the month
     * @param user
     *            for the username
     * @param channel
     *            for the channel name
     * @param countryFrom
     *            for the country
     * @param topic
     *            main topic
     * @param likes1
     *            amount of likes
     * @param posts1
     *            amount of posts
     * @param followers1
     *            amount of followers
     * @param comments1
     *            amount of comments
     * @param views1
     *            amount of views
     */
    public User(
        String month1,
        String user,
        String channel,
        String countryFrom,
        String topic,
        int likes1,
        int posts1,
        int followers1,
        int comments1,
        int views1)
    {
        month = month1;
        username = user;
        channelName = channel;
        country = countryFrom;
        mainTopic = topic;
        likes = likes1;
        posts = posts1;
        followers = followers1;
        comments = comments1;
        views = views1;
    }
    // ~Public Methods ........................................................


    // ----------------------------------------------------------
    /**
     * Returns the number of likes.
     * 
     * @return number of likes.
     */
    public int getLikes()
    {
        return likes;
    }


    // ----------------------------------------------------------
    /**
     * Returns the number of comments.
     * 
     * @return the number of comments.
     */
    public int getComments()
    {
        return comments;
    }


    // ----------------------------------------------------------
    /**
     * Returns the amount of followers.
     * 
     * @return number of followers.
     */
    public int getFollowers()
    {
        return followers;
    }


    // ----------------------------------------------------------
    /**
     * Returns the number of posts.
     * 
     * @return the number of posts.
     */
    public int getPosts()
    {
        return posts;
    }


    // ----------------------------------------------------------
    /**
     * Returns the number of views.
     * 
     * @return number of views.
     */
    public int getViews()
    {
        return views;
    }


    // ----------------------------------------------------------
    /**
     * Gets the username.
     * 
     * @return the username.
     */
    public String getUsername()
    {
        return username;
    }


    // ----------------------------------------------------------
    /**
     * Gets the country.
     * 
     * @return the country.
     */
    public String getCountry()
    {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * Gets the main topic.
     * 
     * @return the main topic.
     */
    public String getMainTopic()
    {
        return mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * Gets the channel name.
     * 
     * @return the channel name.
     */
    public String getChannelName()
    {
        return channelName;
    }


    // ----------------------------------------------------------
    /**
     * Returns the month.
     * 
     * @return the number of months.
     */
    public String getMonth()
    {
        return month;
    }


    /**
     * Changes the amount of likes.
     * 
     * @param likes3
     *            the new amount
     */
    public void setLikes(int likes3)
    {
        likes = likes3;
    }


    /**
     * Changes the amount of followers.
     * 
     * @param followers3
     *            the new amount of followers.
     */
    public void setFollowers(int followers3)
    {
        followers = followers3;
    }


    /**
     * Changes the amount of comments.
     * 
     * @param comments3
     *            new amount of comments.
     */
    public void setComments(int comments3)
    {
        comments = comments3;
    }


    /**
     * Changes the amount of views.
     * 
     * @param views3
     *            new amount of views.
     */
    public void setViews(int views3)
    {
        views = views3;
    }


    // ----------------------------------------------------------
    /**
     * Compares the names of two channels.
     * 
     * @param o
     *            other user
     * @return the numerical representation of the string difference.
     */
    public int compareTo(User o)
    {
        return channelName.compareTo(o.channelName);
    }


    // ----------------------------------------------------------
    /**
     * This method compares the months for each users, which return an int
     * value, which determines if a month is later than another month. For
     * example, March is ranked higher than Janurary.
     * 
     * @return 1 if current month is ranked higher, -1 if current month is
     *             ranked lower, 0 if month is equal
     * @param month
     *            the month being compared to.
     */
    @SuppressWarnings("unlikely-arg-type")
    public int compareByMonth(String month)
    {
        String[] months = new String[12];
        months[0] = "Janurary";
        months[1] = "February";
        months[2] = "March";
        months[3] = "April";
        months[4] = "May";
        months[5] = "June";
        months[6] = "July";
        months[7] = "August";
        months[8] = "September";
        months[9] = "October";
        months[10] = "November";
        months[11] = "December";
        int current = 0;
        int other = 0;
        for (int i = 0; i < months.length; i++)
        {
            if (this.equals(months[i]))
            {
                current = i;
            }
            if (month.equals(months[i]))
            {
                other = i;
            }
        }
        if (current > other)
        {
            return 1;
        }
        else if (current < other)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }


    /**
     * Returns a string.
     * 
     * @return it in a form of a string.
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(
            "" + month + ", " + username + ", " + channelName + ", " + country
                + ", " + mainTopic + ", " + likes + ", " + posts + ", "
                + followers + ", " + comments + ", " + views);
        return s.toString();
    }
}
