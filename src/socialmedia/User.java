package socialmedia;
// -------------------------------------------------------------------------
/**
 *  Represents a user that will be broken down into many parts.
 * 
 *  @author naren
 *  @version Nov 12, 2023
 */
public class User implements Comparable<User>
{
    //~ Fields ................................................................
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
    //~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new User object.
     * @param month1 for the month
     * @param user for the username
     * @param channel for the channel name
     * @param countryFrom for the country
     * @param topic main topic
     * @param likes1 amount of likes
     * @param posts1 amount of posts
     * @param followers1 amount of followers
     * @param comments1 amount of comments
     * @param views1 amount of views
     */
    public User(String month1, String user, String channel, String countryFrom, 
        String topic, int likes1, int posts1, int followers1, int comments1, int views1) {
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
    //~Public  Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Returns the number of likes.
     * @return number of likes.
     */
    public int getLikes() {
        return likes;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns the number of comments.
     * @return the number of comments.
     */
    public int getComments() {
        return comments;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns the amount of followers.
     * @return number of followers.
     */
    public int getFollowers() {
        return followers;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns the number of posts.
     * @return the number of posts.
     */
    public int getPosts() {
        return posts;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns the number of views.
     * @return number of views.
     */
    public int getViews() {
        return views;
    }
    
    // ----------------------------------------------------------
    /**
     * Gets the username.
     * @return the username.
     */
    public String getUsername() {
        return username;
    }
    
    // ----------------------------------------------------------
    /**
     * Gets the country.
     * @return the country.
     */
    public String getCountry() {
        return country;
    }
    
    // ----------------------------------------------------------
    /**
     * Gets the main topic.
     * @return the main topic.
     */
    public String getMainTopic() {
        return mainTopic;
    }
    
    // ----------------------------------------------------------
    /**
     * Gets the channel name.
     * @return the channel name.
     */
    public String getChannelName() {
        return channelName;
    }
    
    // ----------------------------------------------------------
    /**
     * Returns the month.
     * @return the number of months.
     */
    public String getMonth() {
        return month;
    }

    // ----------------------------------------------------------
    /**
     * Compares the names of two channels.
     * @param o other user
     * @return the numerical representation of the string difference.
     */
    public int compareTo(User o)
    {
        return channelName.compareTo(o.channelName);
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("" + month + " " + username + " " + channelName + " " + 
        country + " " + mainTopic + " " + likes + " " + posts + 
        " " + comments + " " + views);
        return s.toString();
    }
}
