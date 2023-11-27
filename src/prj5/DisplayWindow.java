/**
 * 
 */
package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.CircleShape;
import cs2.Shape;
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
    // private static final int PLAYLIST_PADDING = 50;
    // private static final int PLAYLIST_X = PLAYLIST_PADDING;
    // private static final int PLAYLIST_Y = 280;
    // private static final int PLAYLIST_SIZE = ((int)(500 * DISPLAY_FACTOR) -
    // (4
    // * PLAYLIST_PADDING)) / 3;

    private AList<Shape[]> songRectangles;
    // private static final int MUSIC_NOTE_SIZE = 31;
    // private static final int QUEUE_STARTX = MARGIN + 30;
    // private static final int QUEUE_STARTY = 20;
    // private static final int SONG_SHAPE_HEIGHT = 75;

    // private Shape[] playlistShapes = new Shape[3];
    // private CircleShape[] playlistCircles = new CircleShape[3];
    // private static Color[] PLAYLIST_COLORS = new Color[8];

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

        // PLAYLIST_COLORS[0] = new Color(51, 92, 103); // blue
        // PLAYLIST_COLORS[1] = new Color(224, 159, 62); // yellow
        // PLAYLIST_COLORS[2] = new Color(158, 42, 43); // red
        // PLAYLIST_COLORS[3] = new Color(17, 17, 17); // black
        // PLAYLIST_COLORS[4] = new Color(38, 68, 77); // dark blue
        // PLAYLIST_COLORS[5] = new Color(97, 69, 27); // dark yellow
        // PLAYLIST_COLORS[6] = new Color(71, 19, 19); // dark red
        // PLAYLIST_COLORS[7] = new Color(255, 255, 255); // white

        // initButtons();
        // drawPlaylists();
        // drawShapes();
        // updateText();
        // updateButtons();

    }


    /**
     * This method dequeues the pending song at the front of the
     * queue, adding it to the playlist (possibly), and updates the window to
     * represent the current status
     *
     * @param button
     *            accept button (the one that was pressed)
     */

    public void clickedJanuary(Button button) {
        sortChnlName();

    }


    public void clickedFebruary(Button button) {
        sortChnlName();

    }


    public void clickedMarch(Button button) {
        sortChnlName();

    }


    public void clickedfirstQuarter(Button button) {
        sortChnlName();

    }


    public void clickedSortChanlName(Button button) {

        sortChnlName();
    }


    public void clickedSortEngagRate(Button button) {

        sortEngageRate();
        //This class isnt right, just tryna figure out how to create it 
    }


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
    public void sortChnlName() {
        if (!sortingCalculator.sortByName().isEmpty()) {

            if (!sortingCalculator.sortByReachRate().isEmpty()) {

                sortingCalculator.getReachRate(users);
                update();
            }

            if (!sortingCalculator.sortByTraditionalRate().isEmpty()) {
                sortingCalculator.getTraditionalRate(users);
                update();
            }

            users.getChannelName();
            update();

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
                update();
            }

            if (!sortingCalculator.sortByTraditionalRate().isEmpty()) {
                sortingCalculator.getTraditionalRate(users);
                update();
            }

            users.getChannelName();
            update();

        }
        else {
            january.disable();
            february.disable();
            march.disable();
            firstQuarter.disable();
            sortChanlName.disable();
            sortEngagRate.disable();
            endSimulation();
        }// This class is wrong, tryna figure out how to implement it

    }


    /**
     * Update everything. Wipes the screen and resets.
     */
    private void update() {
        if (sortingCalculator.sortByName().isEmpty() && sortingCalculator
            .sortByTraditionalRate().isEmpty() && sortingCalculator
                .sortByReachRate().isEmpty()) {
            endSimulation();
        }
        else {
            // window.removeAllShapes();
            // updateQueue();
            // drawPlaylists();
            // updateText();
            // updateButtons();

        }
    }

    /**
     * Draw the phone objects for the playlists seen on screen
     */
    // private void drawPlaylists() {
    // drawPhone(PLAYLIST_X, PLAYLIST_Y, 0);
    // drawPhone(PLAYLIST_X + PLAYLIST_SIZE + PLAYLIST_PADDING, PLAYLIST_Y, 1);
    // drawPhone(PLAYLIST_X + (2 * PLAYLIST_SIZE) + (2 * PLAYLIST_PADDING),
    // PLAYLIST_Y, 2);
    // }


    /**
     * Helper method to add a TextShape to the window (less overall code)
     */
    private TextShape addTextShape(String message, int x, int y) {
        if (message != null) {
            TextShape shape = new TextShape(x, y, message, Color.black);
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
        quit.disable();
        window.removeAllShapes();
        TextShape simulationStatus = new TextShape(0, 0,
            "All Songs Processed!");
        int x = (window.getGraphPanelWidth() / 2) - (simulationStatus.getWidth()
            / 2);
        int y = (window.getGraphPanelHeight() / 2);
        simulationStatus.moveTo(x, y);
        simulationStatus.setBackgroundColor(Color.white);
        simulationStatus.setForegroundColor(Color.black);
        window.addShape(simulationStatus);
    }

}
