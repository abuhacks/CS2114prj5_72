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
    private SortingCalculator sortingCalculator;
    private User users;
    private Button january;
    private Button february;
    private Button march;
    private Button firstQuarter;
    private Button sortChanlName;
    private Button sortEngagRate;
    private Button tradEngagRate;
    private Button reachEngagRate;
    private Button quit;

    private static final double DISPLAY_FACTOR = 1.5;
    private static final int MARGIN = 12;
    private static final int ENGAGE_PADDING = 50;

    private AList<Shape[]> songRectangles;

    private static final int BAR_GRAPH_SIZE = 10;
    private static final int BAR_GRAPH_WIDTH = 100;
    private static final int BAR_GRAPH_HEIGHT = 200;

    private Shape bar1 = new Shape(60, 350, 35, 200, Color.RED);
    private Shape bar2 = new Shape(175, 350, 35, 200, Color.GREEN);
    private Shape bar3 = new Shape(290, 350, 35, 200, Color.YELLOW);
    private Shape bar4 = new Shape(405, 350, 35, 200, Color.BLUE);

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

        addTextShape("FirstQuarter(Jan-March)", 10, 10);
        addTextShape("Traditional Engagement Rate", 10, 30);
        addTextShape("Sorting by Channel Name", 10, 50);

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

        if (!sortingCalculator.sortByName().isEmpty()) {

            if (!sortingCalculator.sortByReachRate().isEmpty()) {

                window.addShape(bar1);
                window.addShape(bar2);
                window.addShape(bar3);
                window.addShape(bar4);

            }

            if (!sortingCalculator.sortByTraditionalRate().isEmpty()) {
                users.getChannelName();
                sortingCalculator.getTraditionalRate(users);
                window.addShape(bar1);
            }

        }
        else {
            january.disable();
            february.disable();
            march.disable();
            firstQuarter.disable();
            sortChanlName.disable();
            sortEngagRate.disable();
            endSimulation();
        }
    }


    public void sortEngageRate() {
        if (!sortingCalculator.sortByName().isEmpty()) {

            if (!sortingCalculator.sortByReachRate().isEmpty()) {

                sortingCalculator.getReachRate(users);

            }

            if (!sortingCalculator.sortByTraditionalRate().isEmpty()) {
                sortingCalculator.getTraditionalRate(users);

            }

            users.getChannelName();

        }
        else {
            january.disable();
            february.disable();
            march.disable();
            firstQuarter.disable();
            sortChanlName.disable();
            sortEngagRate.disable();
            endSimulation();
        } // This class is wrong, tryna figure out how to implement it

    }


    public void clickedJanuary(Button button) {
        // sortChnlName();

    }


    public void clickedFebruary(Button button) {
        // sortChnlName();

    }


    public void clickedMarch(Button button) {
        // sortChnlName();

    }


    public void clickedfirstQuarter(Button button) {
        // sortChnlName();

    }


    /**
     * Helper method to add a TextShape to the window (less overall code)
     */
    private TextShape addTextShape(String message, int x, int y) {
        if (message != null) {
            TextShape shape = new TextShape(x, y, message, Color.BLACK);
            shape.setBackgroundColor(Color.white);
            window.addShape(shape);
            return shape;
        }
        return null;
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
