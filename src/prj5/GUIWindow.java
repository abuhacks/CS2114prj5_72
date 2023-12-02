// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Naren Dawar(906615413), Joey Chen (906610199), Abiel (906540750), Adam
// (906552490)
/**
 * 
 */
package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import cs2.Button;

import cs2.Shape;

import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * @version 11-30-2023
 * @author Abiel Meaza (abielm)n
 */
public class GUIWindow {

    private Window window;
    private TextShape top;
    private TextShape middle;
    private TextShape bottom;
    private SortingCalculator sortingCalculator;
    private Button january;
    private Button february;
    private Button march;
    private Button firstQuarter;
    private Button sortChanlName;
    private Button sortEngagRate;
    private Button tradEngagRate;
    private Button reachEngagRate;
    private Button quit;

    private String recentMonth;
    private String recentDisplay;
    private String recentSort;

    /**
     * This sets the Display
     * Facotr of the screen
     * to 1.5
     */
    private static final double DISPLAY_FACTOR = 1.5;

    /**
     * The DisplayWindow displays
     * all the data that encapsulates
     * all the information of our project
     * 
     * @param sortingCalculator
     *            this is the sortingCalculator
     *            that is passed through from the sorting Calculator class
     */
    public GUIWindow(SortingCalculator sortingCalculator) {
        window = new Window("abielm, jchen9896, narend, adamschantz");
        window.setSize((int)(500 * DISPLAY_FACTOR), (int)(500
            * DISPLAY_FACTOR));

        this.sortingCalculator = sortingCalculator;

        january = new Button("January");
        window.addButton(january, WindowSide.SOUTH);
        january.onClick(this, "clickedJanuary");

        february = new Button("February");
        window.addButton(february, WindowSide.SOUTH);
        february.onClick(this, "clickedFebruary");

        march = new Button("March");
        window.addButton(march, WindowSide.SOUTH);
        march.onClick(this, "clickedMarch");

        firstQuarter = new Button("First Quarter(Jan - March)");
        window.addButton(firstQuarter, WindowSide.SOUTH);
        firstQuarter.onClick(this, "clickedFirstQuarter");

        sortChanlName = new Button("Sort by Channel Name");
        window.addButton(sortChanlName, WindowSide.NORTH);
        sortChanlName.onClick(this, "clickedSortChanlName");

        sortEngagRate = new Button("Sort by Engagement Rate");
        window.addButton(sortEngagRate, WindowSide.NORTH);
        sortEngagRate.onClick(this, "clickedSortEngagRate");

        quit = new Button("Quit");
        window.addButton(quit, WindowSide.NORTH);
        quit.onClick(this, "clickedQuit");

        tradEngagRate = new Button("Traditional Engagement Rate");
        window.addButton(tradEngagRate, WindowSide.WEST);
        tradEngagRate.onClick(this, "clickedTradEngageRate");

        reachEngagRate = new Button("Reach Engagement Rate");
        window.addButton(reachEngagRate, WindowSide.WEST);
        reachEngagRate.onClick(this, "clickedReachEngagRate");

        top = new TextShape(10, 10, "");
        middle = new TextShape(10, 30, "");
        bottom = new TextShape(10, 50, "");
        window.addShape(top);
        window.addShape(middle);

        window.addShape(bottom);

        recentMonth = "FirstQuarter";
        recentDisplay = "Traditional";
        recentSort = "Engage";

    }


    /**
     * This method ends the simulation when
     * the quit is clicked
     * 
     * @param button
     *            this is the
     *            quit button
     */
    public void clickedQuit(Button button) {

        endSimulation();

    }


    /**
     * When Sort channel name is
     * clicked it checks if the recent
     * sort that was clicked
     * was channelName. Then it goes
     * through continuous
     * amounts of if else statements that
     * check the months and if
     * the user clicks get Traditional
     * or get Reach before displaying
     * the correct information on
     * the top left as a String
     * as well as sorting the data by
     * the channel Name
     * 
     * @param button
     *            This is the button
     *            that is being passed through so
     *            clickedSortChanlName can be clicked
     */
    public void clickedSortChanlName(Button button) {

        recentSort = "ChannelName";

        if (recentDisplay.equals("Traditional") && recentMonth.equals(
            "January")) {
            srtTradJanMonthName();

        }

        if (recentDisplay.equals("Reach") && recentMonth.equals("January")) {
            srtReachJanMonthName();

        }
        if (recentDisplay.equals("Traditional") && recentMonth.equals(
            "February")) {
            srtTradFebMonthName();

        }
        else if (recentDisplay.equals("Reach") && recentMonth.equals(
            "February")) {
            srtReachFebMonthName();

        }
        else if (recentDisplay.equals("Traditional") && recentMonth.equals(
            "March")) {
            srtTradMarMonthName();

        }
        else if (recentDisplay.equals("Reach") && recentMonth.equals("March")) {
            srtReachMarMonthName();

        }
        else if (recentDisplay.equals("Traditional") && recentMonth.equals(
            "FirstQuarter")) {
            srtTradName();

        }
        else if (recentDisplay.equals("Reach") && recentMonth.equals(
            "FirstQuarter")) {
            srtReachName();

        }
    }


    /**
     * The clicked Sorting Engagement Rate
     * Button is treated the same as the
     * Sort Channel Name button but it goes
     * through continuous
     * amounts of if else statements that
     * check the months and if
     * the user clicks get Traditional
     * or get Reach before displaying
     * the correct information on
     * the top left as a String
     * as well as sorting the data by
     * the Engagement Rate
     * it
     * 
     * @param button
     *            is the Sort Engagement
     *            rate button that when clicked runs
     *            the correct data
     */
    public void clickedSortEngagRate(Button button) {

        recentSort = "Engage";

        if (recentMonth.equals("January") && recentDisplay.equals(
            "Traditional")) {
            srtTradJanEngage();
        }
        else if (recentMonth.equals("February") && recentDisplay.equals(
            "Traditional")) {
            srtTradFebEngage();
        }
        else if (recentMonth.equals("March") && recentDisplay.equals(
            "Traditional")) {

            srtTradMarEngage();
        }

        else if (recentMonth.equals("FirstQuarter") && recentDisplay.equals(
            "Traditional")) {

            srtTradEngage();
        }
        else if (recentMonth.equals("January") && recentDisplay.equals(
            "Reach")) {
            srtReachJanEngage();
        }
        else if (recentMonth.equals("February") && recentDisplay.equals(
            "Reach")) {
            srtReachFebEngage();
        }
        else if (recentMonth.equals("March") && recentDisplay.equals("Reach")) {
            srtReachMarEngage();
        }

        else if (recentMonth.equals("FirstQuarter") && recentDisplay.equals(
            "Reach")) {

            srtReachEngage();
        }

    }


    /**
     * This is the clickedJanuary button
     * that when clicked checks what else
     * is clicked and makes sure that the right
     * parameters are clicked before running
     * the right sorters
     * 
     * @param button
     *            this is the clickedJanuary
     *            button that when clicked runs the
     *            correct data specific for january.
     */
    public void clickedJanuary(Button button) {

        recentMonth = "January";

        if (recentSort.equals("Engage") && recentDisplay.equals(
            "Traditional")) {

            srtTradJanEngage();
        }
        else if (recentSort.equals("Engage") && recentDisplay.equals("Reach")) {

            srtReachJanEngage();
        }
        if (recentSort.equals("ChannelName") && recentDisplay.equals(
            "Traditional")) {

            srtTradJanMonthName();
        }
        else if (recentSort.equals("ChannelName") && recentDisplay.equals(
            "Reach")) {
            srtReachJanMonthName();

        }

    }


    /**
     * This is the clickedFebruary button
     * that when clicked checks what else
     * is clicked and makes sure that the right
     * parameters are clicked before running
     * the right sorters
     * 
     * @param button
     *            this is the clickedFebruary
     *            button that when clicked runs the
     *            correct data specific for February.
     */
    public void clickedFebruary(Button button) {

        recentMonth = "February";

        if (recentSort.equals("Engage") && recentDisplay.equals(
            "Traditional")) {

            srtTradFebEngage();
        }
        else if (recentSort.equals("Engage") && recentDisplay.equals("Reach")) {

            srtReachFebEngage();
        }
        if (recentSort.equals("ChannelName") && recentDisplay.equals(
            "Traditional")) {

            srtTradFebMonthName();
        }
        else if (recentSort.equals("ChannelName") && recentDisplay.equals(
            "Reach")) {
            srtReachFebMonthName();

        }

    }


    /**
     * This is the clickedMarch button
     * that when clicked checks what else
     * is clicked and makes sure that the right
     * parameters are clicked before running
     * the right sorters
     * 
     * @param button
     *            this is the clickedMarch
     *            button that when clicked runs the
     *            correct data specific for March.
     */
    public void clickedMarch(Button button) {

        recentMonth = "March";

        if (recentSort.equals("Engage") && recentDisplay.equals(
            "Traditional")) {

            srtTradMarEngage();
        }
        else if (recentSort.equals("Engage") && recentDisplay.equals("Reach")) {

            srtReachMarEngage();
        }
        if (recentSort.equals("ChannelName") && recentDisplay.equals(
            "Traditional")) {

            srtTradMarMonthName();
        }
        else if (recentSort.equals("ChannelName") && recentDisplay.equals(
            "Reach")) {
            srtReachMarMonthName();

        }

    }


    /**
     * This is the clickedFirstQuarter button
     * that when clicked checks what else
     * is clicked and makes sure that the right
     * parameters are clicked before running
     * the right sorters
     * 
     * @param button
     *            this is the clickedFirstQuarter
     *            button that when clicked runs the
     *            correct data specific for FirstQuarter.
     */
    public void clickedFirstQuarter(Button button) {

        recentMonth = "FirstQuarter";

        if (recentSort.equals("Engage") && recentDisplay.equals(
            "Traditional")) {

            srtTradEngage();
        }
        else if (recentSort.equals("Engage") && recentDisplay.equals("Reach")) {

            srtReachEngage();
        }
        if (recentSort.equals("ChannelName") && recentDisplay.equals(
            "Traditional")) {

            srtTradName();
        }
        else if (recentSort.equals("ChannelName") && recentDisplay.equals(
            "Reach")) {
            srtReachName();

        }

    }


    /**
     * When clickedTradEngageRate
     * is clicked it checks which month
     * and which sorter is clicked with if
     * else statements
     * before sorting it with the right
     * method call.
     * 
     * @param button
     *            this is
     *            the clickedTradEngageRate button
     *            that is in the top left part
     *            of the screen
     *            that when clicked gets the traditional
     *            EngagementRate per whichever month
     *            is clicked
     */
    public void clickedTradEngageRate(Button button) {

        recentDisplay = "Traditional";

        if (recentSort.equals("Engage") && recentMonth.equals("January")) {
            srtTradJanEngage();
        }

        else if (recentSort.equals("Engage") && recentMonth.equals(
            "February")) {
            srtTradFebEngage();
        }
        else if (recentSort.equals("Engage") && recentMonth.equals("March")) {
            srtTradMarEngage();
        }
        else if (recentSort.equals("Engage") && recentMonth.equals(
            "FirstQuarter")) {
            srtTradEngage();
        }
        if (recentSort.equals("ChannelName") && recentMonth.equals("January")) {
            srtTradJanMonthName();
        }
        else if (recentSort.equals("ChannelName") && recentMonth.equals(
            "February")) {
            srtTradFebMonthName();
        }
        else if (recentSort.equals("ChannelName") && recentMonth.equals(
            "March")) {
            srtTradMarMonthName();
        }
        else if (recentSort.equals("ChannelName") && recentMonth.equals(
            "FirstQuarter")) {
            srtTradName();
        }

    }


    /**
     * When clickedReachEngageRate
     * is clicked it checks which month
     * and which sorter is clicked with if
     * else statements
     * before sorting it with the right
     * method call.
     * 
     * @param button
     *            this is
     *            the clickedReachEngagRate button
     *            that is in the top left part
     *            of the screen
     *            that when clicked gets the reach
     *            EngagementRate per whichever month
     *            is clicked
     */
    public void clickedReachEngagRate(Button button) {

        recentDisplay = "Reach";

        if (recentSort.equals("Engage") && recentMonth.equals("January")) {

            srtReachJanEngage();
        }
        else if (recentSort.equals("Engage") && recentMonth.equals(
            "February")) {

            srtReachFebEngage();
        }
        else if (recentSort.equals("Engage") && recentMonth.equals("March")) {

            srtReachMarEngage();
        }
        else if (recentSort.equals("Engage") && recentMonth.equals(
            "FirstQuarter")) {
            srtReachEngage();
        }
        if (recentSort.equals("ChannelName") && recentMonth.equals("January")) {
            srtReachJanMonthName();
        }
        else if (recentSort.equals("ChannelName") && recentMonth.equals(
            "February")) {
            srtReachFebMonthName();
        }
        else if (recentSort.equals("ChannelName") && recentMonth.equals(
            "March")) {
            srtReachMarMonthName();
        }
        else if (recentSort.equals("ChannelName") && recentMonth.equals(
            "FirstQuarter")) {
            srtReachName();
        }

    }


    /**
     * The traditional
     * Rate method gets the traditional
     * rate by creating a user within
     * the doubly linked list
     * and gets the list through our
     * sortingCalculator class
     * and then draws the correct
     * bar graph for Traditional values.
     */
    public void tradRate() {
        DoublyLinkedList<User> abu1 = new DoublyLinkedList<User>();
        abu1 = sortingCalculator.getList();
        drawBarGraphTrad(abu1, tradEngagRate);

    }


    /**
     * The reach
     * Rate method gets the reac
     * rate by creating a user within
     * the doubly linked list
     * and gets the list through our
     * sortingCalculator class
     * and then draws the correct
     * bar graph for reach values.
     */
    @SuppressWarnings("unused")
    private void reachRate() {
        DoublyLinkedList<User> abu2 = new DoublyLinkedList<User>();
        abu2 = sortingCalculator.getList();
        drawBarGraphReach(abu2, reachEngagRate);

    }


    /**
     * The sort Traditional Name method gets the
     * traditional name by creating a user within
     * the sortingCalculator class and calling
     * the sort by name class. Then it gets
     * the correct Channel Name by traversing
     * through a for loop (the length) and
     * then drawing the correct traditional
     * graph
     */
    private void srtTradName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByName();
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            drawBarGraphTrad(abu, sortChanlName);

        }

    }


    /**
     * The sort Reach Name method gets the
     * reach name by creating a user within
     * the sortingCalculator class and calling
     * the sort by name class. Then it gets
     * the correct Channel Name by traversing
     * through a for loop (the length) and
     * then drawing the correct reach
     * graph
     */
    private void srtReachName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByName();
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            drawBarGraphReach(abu, sortChanlName);

        }
    }


    /**
     * This does the same thing as
     * the sort Traditional Name
     * method but it sorts the
     * traditional name method
     * specifically for the month
     * January.
     */
    public void srtTradJanMonthName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByMonth("January");
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            tradMonth(abu, sortChanlName);
        }
    }


    /**
     * This does the same thing as
     * the sort Reach Name
     * method but it sorts the
     * reach name method
     * specifically for the month
     * January.
     */
    public void srtReachJanMonthName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByMonth("January");
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            reachMonth(abu, sortChanlName);
        }
    }


    /**
     * This does the same thing as
     * the sort Traditional Name
     * method but it sorts the
     * traditional name method
     * specifically for the month
     * February.
     */
    public void srtTradFebMonthName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByMonth("February");
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            tradMonth(abu, sortChanlName);
        }

    }


    /**
     * This does the same thing as
     * the sort Traditional Name
     * method but it sorts the
     * traditional name method
     * specifically for the month
     * January.
     */
    public void srtReachFebMonthName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByMonth("February");
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            reachMonth(abu, sortChanlName);
        }
    }


    /**
     * This does the same thing as
     * the sort Traditional Name
     * method but it sorts the
     * traditional name method
     * specifically for the month
     * March.
     */
    public void srtTradMarMonthName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByMonth("March");
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            tradMonth(abu, sortChanlName);
        }
    }


    /**
     * This does the same thing as
     * the sort Reach Name
     * method but it sorts the
     * reach name method
     * specifically for the month
     * March.
     */
    public void srtReachMarMonthName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByMonth("March");
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            reachMonth(abu, sortChanlName);
        }
    }

// /**
// * This does the same thing as
// * the sort Traditional Name
// * method but it sorts the
// * traditional name method
// * specifically for the month
// * FirstQuarter.
// */
// public void srtTradFirstQName() {
// DoublyLinkedList<User> abu = sortingCalculator.sortByName();
// for (int i = 0; i < abu.getLength(); i++) {
// abu.getEntry(i).getChannelName();
// drawBarGraphTrad(abu, sortChanlName);
//
// }
//
// }
//
//
// /**
// * This does the same thing as
// * the sort Reach Name
// * method but it sorts the
// * reach name method
// * specifically for the month
// * FirstQuarter.
// */
// public void srtReachFirstQName() {
// DoublyLinkedList<User> abu = sortingCalculator.sortByName();
// for (int i = 0; i < abu.getLength(); i++) {
// abu.getEntry(i).getChannelName();
// drawBarGraphReach(abu, sortChanlName);
//
// }
//
// }


    /**
     * This Sorts the Traditional
     * rate data by calling
     * sort by traditional rate
     * through the sorting Calculator
     * and then traversing through the
     * length of the rates and then
     * drawing them based on the the data
     * in traditional.
     */
    private void srtTradEngage() {

        DoublyLinkedList<User> abu = sortingCalculator.sortByTraditionalRate();
        for (int i = 0; i < abu.getLength(); i++) {
            drawBarGraphTrad(abu, sortEngagRate);

        }

    }


    /**
     * This Sorts the Reach
     * rate data by calling
     * sort by reach rate
     * through the sorting Calculator
     * and then traversing through the
     * length of the rates and then
     * drawing them based on the the data
     * in reach.
     */
    private void srtReachEngage() {
        DoublyLinkedList<User> abu1 = sortingCalculator.sortByReachRate();
        for (int i = 0; i < abu1.getLength(); i++) {
            drawBarGraphReach(abu1, sortEngagRate);

        }
    }


    /**
     * This does the same thing
     * as the srtTradEngage
     * class but it sorts it based
     * on the month January.
     */
    private void srtTradJanEngage() {
        DoublyLinkedList<User> abu2 = sortingCalculator.sortByTradMonth(
            "January");
        for (int i = 0; i < abu2.getLength(); i++) {
            tradMonth(abu2, sortEngagRate);

        }

    }


    /**
     * This does the same thing
     * as the srtReachEngage
     * class but it sorts it based
     * on the month January.
     */
    private void srtReachJanEngage() {
        DoublyLinkedList<User> abu2 = sortingCalculator.sortByReachMonth(
            "January");
        for (int i = 0; i < abu2.getLength(); i++) {
            reachMonth(abu2, sortEngagRate);

        }

    }


    /**
     * This does the same thing
     * as the srtTradEngage
     * class but it sorts it based
     * on the month February.
     */
    private void srtTradFebEngage() {
        DoublyLinkedList<User> abu2 = sortingCalculator.sortByTradMonth(
            "February");
        for (int i = 0; i < abu2.getLength(); i++) {
            tradMonth(abu2, sortEngagRate);

        }

    }


    /**
     * This does the same thing
     * as the srtReachEngage
     * class but it sorts it based
     * on the month February.
     */
    private void srtReachFebEngage() {
        DoublyLinkedList<User> abu2 = sortingCalculator.sortByReachMonth(
            "February");
        for (int i = 0; i < abu2.getLength(); i++) {
            reachMonth(abu2, sortEngagRate);

        }

    }


    /**
     * This does the same thing
     * as the srtTradEngage
     * class but it sorts it based
     * on the month March.
     */
    private void srtTradMarEngage() {
        DoublyLinkedList<User> abu6 = sortingCalculator.sortByTradMonth(
            "March");
        for (int i = 0; i < abu6.getLength(); i++) {
            tradMonth(abu6, sortEngagRate);

        }

    }


    /**
     * This does the same thing
     * as the srtReachEngage
     * class but it sorts it based
     * on the month March.
     */
    private void srtReachMarEngage() {
        DoublyLinkedList<User> abu2 = sortingCalculator.sortByReachMonth(
            "March");
        for (int i = 0; i < abu2.getLength(); i++) {
            reachMonth(abu2, sortEngagRate);

        }

    }


    /**
     * This does the same thing
     * as the srtTradEngage
     * class but it sorts it based
     * on the month FirstQuarter.
     */
    public void tradFirstQuarterRate() {
        DoublyLinkedList<User> abu14 = new DoublyLinkedList<User>();
        abu14 = sortingCalculator.getUsers();
        tradFirstQMonth(abu14, firstQuarter);

    }


    /**
     * 
     * @param abu
     *            this is the user that
     *            is used within the class
     * @param button
     *            this is the button
     *            that is being clicked when the first
     *            quarter method
     *            is called above
     *            When this class is called above,
     *            it will draw the only the firstQuarter
     *            data.
     */
    private void tradFirstQMonth(DoublyLinkedList<User> abu, Button button) {
        window.removeAllShapes();
        clickedS(button);

        int barSpacing = 100;
        int initialX = 30;

        Color[] colors = { Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW };

        for (int i = 0; i < Math.min(abu.getLength(), 4); i++) {
            User user = abu.getEntry(i);
            double traditionalMRate = sortingCalculator.getTraditionalRate(
                user);
            String channelName = user.getChannelName();

            int barWidth = 30;
            int barHeight = (int)(traditionalMRate);

            Shape bar = new Shape(initialX + i * (barWidth + barSpacing), 550
                - barHeight, barWidth, barHeight, colors[i]);
            window.addShape(bar);

            TextShape textShape = new TextShape(initialX + i * (barWidth
                + barSpacing), 570, channelName, Color.BLACK);
            window.addShape(textShape);

            TextShape textShapeRate = new TextShape(initialX + i * (barWidth
                + barSpacing), 590, String.format("%.2f", traditionalMRate),
                Color.BLACK);
            window.addShape(textShapeRate);
        }

        window.repaint();
    }


    /**
     * @param abu
     *            this is the user
     *            that is being used within the class
     * 
     * @param button
     *            this is the button be clicked above
     *            when tradMonth is called for all the months
     *            in the project
     *            When this class is called above,
     *            it will draw all the months bars graphs
     *            except FirstQuarter
     *            data for traditional data.
     * 
     */
    private void tradMonth(DoublyLinkedList<User> abu, Button button) {
        window.removeAllShapes();
        clickedS(button);

        int barSpacing = 100;
        int initialX = 30;

        Color[] colors = { Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW };

        for (int i = 0; i < Math.min(abu.getLength(), 4); i++) {
            User user = abu.getEntry(i);
            double traditionalMRate = sortingCalculator.getIndividualTradRate(
                user);
            String channelName = user.getChannelName();

            int barWidth = 30;
            int barHeight = (int)(traditionalMRate);

            Shape bar = new Shape(initialX + i * (barWidth + barSpacing), 550
                - barHeight, barWidth, barHeight, colors[i]);
            window.addShape(bar);

            TextShape textShape = new TextShape(initialX + i * (barWidth
                + barSpacing), 570, channelName, Color.BLACK);
            window.addShape(textShape);

            TextShape textShapeRate = new TextShape(initialX + i * (barWidth
                + barSpacing), 590, String.format("%.2f", traditionalMRate),
                Color.BLACK);

            window.addShape(textShapeRate);
        }

        window.repaint();
    }


    /**
     * 
     * @param abu
     *            this is the user
     *            that is being used within the class.
     * @param button
     *            this is the button that
     *            is being clicked when reachMonth is called
     *            above
     * 
     *            When this class is called above,
     *            it will draw all the months bars graphs
     *            except FirstQuarter
     *            data for reach data.
     */
    private void reachMonth(DoublyLinkedList<User> abu, Button button) {
        window.removeAllShapes();
        clickedS(button);
        int barSpacing = 100;
        int initialX = 30;

        Color[] colors = { Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW };

        for (int i = 0; i < Math.min(abu.getLength(), 4); i++) {
            User user = abu.getEntry(i);
            double reachMRate = sortingCalculator.getIndividualReachRate(user);
            String channelName = user.getChannelName();

            int barWidth = 30;
            int barHeight = (int)(reachMRate);

            Shape bar = new Shape(initialX + i * (barWidth + barSpacing), 550
                - barHeight, barWidth, barHeight, colors[i]);
            window.addShape(bar);

            TextShape textShape = new TextShape(initialX + i * (barWidth
                + barSpacing), 570, channelName, Color.BLACK);
            window.addShape(textShape);

            TextShape textShapeRate;

            if (reachMRate < 0.1) {
                textShapeRate = new TextShape(initialX + i * (barWidth
                    + barSpacing), 590, "N/A", Color.BLACK);
            }
            else {
                textShapeRate = new TextShape(initialX + i * (barWidth
                    + barSpacing), 590, String.format("%.2f", reachMRate),
                    Color.BLACK);
            }

            window.addShape(textShapeRate);
        }

        window.repaint();
    }


    /**
     * @param abu
     *            this is the user
     *            that is being used within the class.
     * @param button
     *            this is being clicked above just
     *            for the traditional data, ("NOT THE MONTH TRADITIONAL DATA")
     *            When this class is called above,
     *            it will draw all the bars graphs
     *            data for traditional data.
     * 
     */
    private void drawBarGraphTrad(DoublyLinkedList<User> abu, Button button) {
        window.removeAllShapes();
        clickedS(button);
        int barSpacing = 100;
        int initialX = 30;

        Color[] colors = { Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW };

        for (int i = 0; i < Math.min(abu.getLength(), 4); i++) {
            User user = abu.getEntry(i);
            double traditionalRate = sortingCalculator.getTraditionalRate(user);
            String channelName = user.getChannelName();

            int barWidth = 30;
            int barHeight = (int)(traditionalRate);

            Shape bar = new Shape(initialX + i * (barWidth + barSpacing), 550
                - barHeight, barWidth, barHeight, colors[i]);
            window.addShape(bar);

            TextShape textShape = new TextShape(initialX + i * (barWidth
                + barSpacing), 570, channelName, Color.BLACK);
            window.addShape(textShape);

            TextShape textShapeRate;
            if (traditionalRate < 0.1) {
                textShapeRate = new TextShape(initialX + i * (barWidth
                    + barSpacing), 590, "N/A", Color.BLACK);
                window.addShape(textShapeRate);
            }
            else {
                textShapeRate = new TextShape(initialX + i * (barWidth
                    + barSpacing), 590, String.format("%.2f", traditionalRate),
                    Color.BLACK);
                window.addShape(textShapeRate);
            }

        }

        window.repaint();
    }


    /**
     * @param abu
     *            this is the user
     *            that is being used within the class.
     * @param button
     *            this is being clicked above just
     *            for the reach data, ("NOT THE MONTH REACH DATA")
     *            When this class is called above,
     *            it will draw all the bars graphs
     *            data for reach data.
     * 
     */
    private void drawBarGraphReach(DoublyLinkedList<User> abu, Button button) {
        window.removeAllShapes();
        clickedS(button);
        int barSpacing = 100;
        int initialX = 40;

        Color[] colors = { Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW };

        for (int i = 0; i < Math.min(abu.getLength(), 4); i++) {
            User user = abu.getEntry(i);
            double reachRate = sortingCalculator.getReachRate(user);
            String channelName = user.getChannelName();

            int barWidth = 30;
            int barHeight = (int)(reachRate);

            Shape bar = new Shape(initialX + i * (barWidth + barSpacing), 550
                - barHeight, barWidth, barHeight, colors[i]);
            window.addShape(bar);

            TextShape textShape = new TextShape(initialX + i * (barWidth
                + barSpacing), 570, channelName, Color.BLACK);
            window.addShape(textShape);

            TextShape textShapeRate;
            if (reachRate < 0.1) {
                textShapeRate = new TextShape(initialX + i * (barWidth
                    + barSpacing), 590, "N/A", Color.BLACK);
                window.addShape(textShapeRate);
            }
            else {
                textShapeRate = new TextShape(initialX + i * (barWidth
                    + barSpacing), 590, String.format("%.2f", reachRate),
                    Color.BLACK);
                window.addShape(textShapeRate);
            }
        }

        window.repaint();
    }


    /**
     * 
     * @param button
     *            these buttons are clicked
     *            above to make the string values
     *            on the top left of the screen change
     *            in the correct way no matter what
     *            This is the clickedS() class that
     *            takes in a button parameter and
     *            checks if the recentMonth, recentDisplay, and
     *            recentSort are equal to the correct string values
     *            before adding the shapes in the correct place
     *            on the screen
     */
    private void clickedS(Button button) {

        if (recentMonth.equals("January")) {
            top.setText("January");
            window.addShape(top);
        }
        else if (recentMonth.equals("February")) {
            top.setText("February");
            window.addShape(top);
        }
        else if (recentMonth.equals("March")) {
            top.setText("March");
            window.addShape(top);
        }
        else if (recentMonth.equals("FirstQuarter")) {
            top.setText("First Quarter(Jan - March)");
            window.addShape(top);
        }
        if (recentDisplay.equals("Traditional")) {
            middle.setText("Traditional Engagement Rate");
            window.addShape(middle);
        }
        else if (recentDisplay.equals("Reach")) {
            middle.setText("Reach Engagement Rate");
            window.addShape(middle);
        }
        if (recentSort.equals("ChannelName")) {
            bottom.setText("Sort By Channel Name");
            window.addShape(bottom);

        }
        else if (recentSort.equals("Engage")) {
            bottom.setText("Sort By Engagement Rate");
            window.addShape(bottom);

        }

    }


    /**
     * This method disables the buttons and is
     * called when the quit is called.
     */
    private void endSimulation() {
        january.disable();
        february.disable();
        march.disable();
        firstQuarter.disable();
        sortChanlName.disable();
        sortEngagRate.disable();
        tradEngagRate.disable();
        reachEngagRate.disable();
        quit.disable();
        window.removeAllShapes();
        System.exit(0);
    }

}
