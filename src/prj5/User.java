package prj5;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Naren Dawar(naren)(906615413), Joey Chen (PID),
// --Abiel (PID), Adam (PID)
// -------------------------------------------------------------------------
/**
 * Represents a user that will be broken down into many parts that can be used
 * in the Linked List.
 * 
 * @author naren
 * @version Nov 12, 2023
 */
public class User implements Comparable<User> {
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
        int views1) {
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
    public int getLikes() {
        return likes;
    }


    // ----------------------------------------------------------
    /**
     * Returns the number of comments.
     * 
     * @return the number of comments.
     */
    public int getComments() {
        return comments;
    }


    // ----------------------------------------------------------
    /**
     * Returns the amount of followers.
     * 
     * @return number of followers.
     */
    public int getFollowers() {
        return followers;
    }


    // ----------------------------------------------------------
    /**
     * Returns the number of posts.
     * 
     * @return the number of posts.
     */
    public int getPosts() {
        return posts;
    }


    // ----------------------------------------------------------
    /**
     * Returns the number of views.
     * 
     * @return number of views.
     */
    public int getViews() {
        return views;
    }


    // ----------------------------------------------------------
    /**
     * Gets the username of the user.
     * 
     * @return the corresponding username.
     */
    public String getUsername() {
        return username;
    }


    // ----------------------------------------------------------
    /**
     * Gets the country of the user.
     * 
     * @return the country the user is based in.
     */
    public String getCountry() {
        return country;
    }


    // ----------------------------------------------------------
    /**
     * Gets the main topic of the user.
     * 
     * @return the main topic of the user.
     */
    public String getMainTopic() {
        return mainTopic;
    }


    // ----------------------------------------------------------
    /**
     * Gets the user's channel name.
     * 
     * @return the channel name.
     */
    public String getChannelName() {
        return channelName;
    }


    // ----------------------------------------------------------
    /**
     * Returns the month of the specific user.
     * 
     * @return the number of months.
     */
    public String getMonth() {
        return month;
    }


    /**
     * Changes the amount of likes for the user.
     * 
     * @param likes3
     *            the new amount
     */
    public void setLikes(int likes3) {
        likes = likes3;
    }


    /**
     * Changes the amount of followers for the user.
     * 
     * @param followers3
     *            the new amount of followers.
     */
    public void setFollowers(int followers3) {
        followers = followers3;
    }


    /**
     * Changes the amount of comments for the user.
     * 
     * @param comments3
     *            new amount of comments.
     */
    public void setComments(int comments3) {
        comments = comments3;
    }


    /**
     * Changes the amount of views for the user.
     * 
     * @param views3
     *            new amount of views.
     */
    public void setViews(int views3) {
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
    public int compareTo(User o) {
        return channelName.compareTo(o.channelName);
    }


    /**
     * Returns a string representation of the
     * 
     * @return it in a form of a string.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("" + month + ", " + username + ", " + channelName + ", "
            + country + ", " + mainTopic + ", " + likes + ", " + posts + ", "
            + followers + ", " + comments + ", " + views);
        return s.toString();
    }


    // ----------------------------------------------------------
    /**
     * Gets the users individual traditional rate.
     * 
     * @return the traditional rate.
     */
    public double getIndividualTradRate() {
        return ((this.getComments() + this.getLikes()) / 
            (double)this
            .getFollowers()) * 100;
    }


    // ----------------------------------------------------------
    /**
     * Gets the users individual reach rate.
     * 
     * @return the reach rate.
     */
    public double getIndividualReachRate() {
        return ((this.getComments() + this.getLikes()) / 
            (double)this
            .getViews()) * 100;
    }
}
