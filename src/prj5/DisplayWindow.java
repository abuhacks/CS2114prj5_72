/**
 * 
 */
package prj5;

import java.awt.Color;
import javax.print.DocFlavor.STRING;
import cs2.Button;
import cs2.CircleShape;
import cs2.Shape;
import cs2.SquareShape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import prj5.SortingCalculator;
import prj5.User;
import list.AList;

/**
 * 
 */
public class DisplayWindow {

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

    private static final double DISPLAY_FACTOR = 1.5;
    private AList<Shape[]> songRectangles;

    /**
     * 
     */
    public DisplayWindow(SortingCalculator sortingCalculator) {
        window = new Window("Social Media Vis");
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

        this.songRectangles = new AList<Shape[]>();

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
     * This method dequeues the pending song at the front of the
     * queue, adding it to the playlist (possibly), and updates the window to
     * represent the current status
     *
     * @param button
     *            accept button (the one that was pressed)
     */

    /**
     * 
     * @param button
     */
    public void clickedQuit(Button button) {

        endSimulation();

    }


    /**
     * 
     */
    public void clickedSortChanlName(Button button) {
        recentSort = "ChannelName";
        if (recentDisplay.equals("Traditional")) {
            srtTradName();
        }

        else if (recentDisplay.equals("Reach")) {
            srtReachName();

        }

    }


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


    public void clickedJanuary(Button button) {

        recentMonth = "January";

        if (recentSort.equals("Engage") && recentDisplay.equals(
            "Traditional")) {

            srtTradJanEngage();
        }
        else if (recentSort.equals("Engage") && recentDisplay.equals("Reach")) {

            srtReachJanEngage();
        }
        else {

            //
        }

    }


    public void clickedFebruary(Button button) {

        recentMonth = "February";

        if (recentSort.equals("Engage") && recentDisplay.equals(
            "Traditional")) {

            srtTradFebEngage();
        }
        else if (recentSort.equals("Engage") && recentDisplay.equals("Reach")) {

            srtReachFebEngage();
        }
        else {
            //
        }

    }


    public void clickedMarch(Button button) {

        recentMonth = "March";

        if (recentSort.equals("Engage") && recentDisplay.equals(
            "Traditional")) {

            srtTradMarEngage();
        }
        else if (recentSort.equals("Engage") && recentDisplay.equals("Reach")) {

            srtReachMarEngage();
        }
        else {
            //
        }

    }


    public void clickedFirstQuarter(Button button) {

        recentMonth = "FirstQuarter";

        if (recentSort.equals("Engage") && recentDisplay.equals(
            "Traditional")) {

            srtTradEngage();
        }
        else if (recentSort.equals("Engage") && recentDisplay.equals("Reach")) {

            srtReachEngage();
        }
        else {
            //
        }

    }


    /**
     * 
     * @param button
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

    }


    /**
     * 
     * @param button
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

    }


    /**
     * @return
     * 
     */
    public void tradRate() {
        DoublyLinkedList<User> abu1 = new DoublyLinkedList<User>();
        abu1 = sortingCalculator.getList();
        drawBarGraphTrad(abu1, tradEngagRate);

    }


    /**
     * 
     */
    public void reachRate() {
        DoublyLinkedList<User> abu2 = new DoublyLinkedList<User>();
        abu2 = sortingCalculator.getList();
        drawBarGraphReach(abu2, reachEngagRate);

    }


    /**
     * 
     */
    public void srtTradName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByName();
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            drawBarGraphTrad(abu, sortChanlName);

        }

    }


    /**
     * 
     */
    public void srtReachName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByName();
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            drawBarGraphReach(abu, sortChanlName);

        }
    }


    /**
     * 
     */
    public void srtTradEngage() {

        DoublyLinkedList<User> abu = sortingCalculator.sortByTraditionalRate();
        for (int i = 0; i < abu.getLength(); i++) {
            drawBarGraphTrad(abu, sortEngagRate);

        }

    }


    public void srtReachEngage() {
        DoublyLinkedList<User> abu1 = sortingCalculator.sortByReachRate();
        for (int i = 0; i < abu1.getLength(); i++) {
            drawBarGraphReach(abu1, sortEngagRate);

        }
    }


    /**
     * 
     */
    public void srtTradJanEngage() {
        DoublyLinkedList<User> abu2 = sortingCalculator.sortByTradMonth(
            "January");
        for (int i = 0; i < abu2.getLength(); i++) {
            tradMonth(abu2, sortEngagRate);

        }

    }


    public void srtReachJanEngage() {
        DoublyLinkedList<User> abu2 = sortingCalculator.sortByReachMonth(
            "January");
        for (int i = 0; i < abu2.getLength(); i++) {
            reachMonth(abu2, sortEngagRate);

        }

    }


    /**
     * 
     */
    public void srtTradFebEngage() {
        DoublyLinkedList<User> abu2 = sortingCalculator.sortByTradMonth(
            "February");
        for (int i = 0; i < abu2.getLength(); i++) {
            tradMonth(abu2, sortEngagRate);

        }

    }


    public void srtReachFebEngage() {
        DoublyLinkedList<User> abu2 = sortingCalculator.sortByReachMonth(
            "February");
        for (int i = 0; i < abu2.getLength(); i++) {
            reachMonth(abu2, sortEngagRate);

        }

    }


    public void srtTradMarEngage() {
        DoublyLinkedList<User> abu6 = sortingCalculator.sortByTradMonth(
            "March");
        for (int i = 0; i < abu6.getLength(); i++) {
            tradMonth(abu6, sortEngagRate);

        }

    }


    public void srtReachMarEngage() {
        DoublyLinkedList<User> abu2 = sortingCalculator.sortByReachMonth(
            "March");
        for (int i = 0; i < abu2.getLength(); i++) {
            reachMonth(abu2, sortEngagRate);

        }

    }


    public void tradFirstQuarterRate() {
        DoublyLinkedList<User> abu14 = new DoublyLinkedList<User>();
        abu14 = sortingCalculator.getUsers();
        tradFirstQMonth(abu14, firstQuarter);

    }


    public void tradFirstQMonth(DoublyLinkedList<User> abu, Button button) {
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
     * 
     */
    public void tradMonth(DoublyLinkedList<User> abu, Button button) {
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


    public void reachMonth(DoublyLinkedList<User> abu, Button button) {
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

            TextShape textShapeRate = new TextShape(initialX + i * (barWidth
                + barSpacing), 590, String.format("%.2f", reachMRate),
                Color.BLACK);
            window.addShape(textShapeRate);
        }

        window.repaint();
    }


    /**
     * @param abu
     * 
     */
    public void drawBarGraphTrad(DoublyLinkedList<User> abu, Button button) {
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

            TextShape textShapeRate = new TextShape(initialX + i * (barWidth
                + barSpacing), 590, String.format("%.2f", traditionalRate),
                Color.BLACK);
            window.addShape(textShapeRate);
        }

        window.repaint();
    }


    /**
     * @param button
     * 
     */
    public void drawBarGraphReach(DoublyLinkedList<User> abu, Button button) {
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

            TextShape textShapeRate = new TextShape(initialX + i * (barWidth
                + barSpacing), 590, String.format("%.2f", reachRate),
                Color.BLACK);
            window.addShape(textShapeRate);
        }

        window.repaint();
    }


    /**
     * 
     * @param button
     */
    public void clickedS(Button button) {

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
     * This method disables the buttons and is called when the queue is empty
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
