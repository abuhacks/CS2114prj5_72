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
    private boolean bear;
    private boolean cap;

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

        bear = false;
        cap = true;

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
        if (bear) {
            srtTradName();
            bear = false;
        }
        else if (cap) {
            srtReachName();
            cap = false;
        }
    }


    public void clickedSortEngagRate(Button button) {

    }


    public void clickedJanuary(Button button) {

    }


    public void clickedFebruary(Button button) {

    }


    public void clickedMarch(Button button) {

    }


    public void clickedFirstQuarter(Button button) {

    }


    /**
     * 
     * @param button
     */
    public void clickedTradEngageRate(Button button) {

        tradRate();

    }


    /**
     * 
     * @param button
     */
    public void clickedReachEngagRate(Button button) {

        reachRate();

    }


    /**
     * @return
     * 
     */
    public void tradRate() {
        DoublyLinkedList<User> abu1 = new DoublyLinkedList<User>();
        abu1 = sortingCalculator.getList();
        drawBarGraphTrad(abu1);
        bear = true;
    }


    /**
     * 
     */
    public void reachRate() {
        DoublyLinkedList<User> abu2 = new DoublyLinkedList<User>();
        abu2 = sortingCalculator.getList();
        drawBarGraphReach(abu2);
        cap = true;
    }


    /**
     * 
     */
    public void srtTradName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByName();
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            drawBarGraphTrad(abu);

        }

    }


    /**
     * 
     */
    public void srtReachName() {
        DoublyLinkedList<User> abu = sortingCalculator.sortByName();
        for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            drawBarGraphReach(abu);

        }
    }


    /**
     * 
     */
    public void srtTradEngage() {
        
        DoublyLinkedList<User> abu = sortingCalculator.sortByTraditionalRate();
            for (int i = 0; i < abu.getLength(); i++) {
            abu.getEntry(i).getChannelName();
            drawBarGraphTrad(abu);

        }

    }


    /**
     * @param abu
     * 
     */
    public void drawBarGraphTrad(DoublyLinkedList<User> abu) {
        window.removeAllShapes();

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
     * 
     */
    public void drawBarGraphReach(DoublyLinkedList<User> abu) {
        window.removeAllShapes();

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
        if (button.equals(january)) {
            top.setText("January");
        }
        else if (button.equals(february)) {
            top.setText("February");
        }
        else if (button.equals(march)) {
            top.setText("March");
        }
        else if (button.equals(firstQuarter)) {
            top.setText("First Quarter(Jan - March)");
        }
        else if (button.equals(tradEngagRate)) {
            middle.setText("Traditional Engagement Rate");
        }
        else if (button.equals(reachEngagRate)) {
            middle.setText("Reach Engagement Rate");
        }
        else if (button.equals(sortChanlName)) {
            bottom.setText("Sort By Channel Name");

        }
        else if (button.equals(sortEngagRate)) {
            bottom.setText("Sort By Engagement Rate");

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
