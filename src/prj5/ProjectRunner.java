/**
 * 
 */
package prj5;

import java.io.IOException;

/**
 * This is the ProjectRunner Class that takes in the InputFileReader and reads
 * the Sample Input and spits out an output.
 */
public class ProjectRunner {

    public static void main(String[] args) throws IOException {
        InputFileReader filer;

        if (args.length > 0) {
            filer = new InputFileReader(args[0]);
        }
        else {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }
        boolean showConsole = true;
        boolean showGUI = false;
        if (showConsole) {
            System.out.println(filer);
        }
        if (showGUI) {
            /*
             * TODO: For final Submission - Should have the GUI display for the
             * input data
             */
        }
    }

}
