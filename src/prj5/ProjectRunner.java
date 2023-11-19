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
            SortingCalculator newTemp = new SortingCalculator(filer.getList());
            DoublyLinkedList<User> newList = newTemp.sortByName();
            DoublyLinkedList<User> newList2 = newTemp.sortByReachRate();
            for(int i = 0; i < newList.getLength(); i++) {
                System.out.println(newList.getEntry(i).getChannelName());
                System.out.println("traditional: " + newTemp.getTraditionalRate(newList.getEntry(i)));
                System.out.println("==========");
                if(i == newList.getLength() - 1) {
                    System.out.println("**********");
                    System.out.println("**********");
                }
            }
            for(int j = 0; j < newList2.getLength(); j++) {
                System.out.println(newList2.getEntry(j).getChannelName());
                System.out.println("reach: " + newTemp.getReachRate(newList2.getEntry(j)));
                System.out.println("==========");
            }
        }
        if (showGUI) {
            /*
             * TODO: For final Submission - Should have the GUI display for the
             * input data
             */
        }
    }

}
