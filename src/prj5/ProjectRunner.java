
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I
// accept the actions of those who do.
// -- Naren Dawar(906615413), Joey Chen (906610199), Abiel (906540750), Adam
// (906552490)/**

package prj5;

import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * This is the ProjectRunner Class that takes in the InputFileReader and reads
 * the Sample Input and spits out an output.
 */
public class ProjectRunner {

    // ----------------------------------------------------------
    /**
     * This runs the entire program.
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        InputFileReader filer;

        if (args.length > 0) {
            filer = new InputFileReader(args[0]);
        }
        else {
            filer = new InputFileReader("SampleInput3_2023.csv");
        }
        boolean showConsole = true;
        boolean showGUI = true;
        if (showConsole) {
            DecimalFormat decimal = new DecimalFormat("#.#");
            SortingCalculator newTemp = new SortingCalculator(filer.getList());
            DoublyLinkedList<User> newList = newTemp.sortByName();
            DoublyLinkedList<User> newList2 = newTemp.sortByReachRate();
            for (int i = 0; i < newList.getLength(); i++) {
                System.out.println(newList.getEntry(i).getChannelName());
                System.out.println("traditional: " + decimal.format(newTemp
                    .getTraditionalRate(newList.getEntry(i))));
                System.out.println("==========");
                if (i == newList.getLength() - 1) {
                    System.out.println("**********");
                    System.out.println("**********");
                }
            }
            for (int j = 0; j < newList2.getLength(); j++) {
                System.out.println(newList2.getEntry(j).getChannelName());
                String letter = "reach: " + decimal.format(newTemp.getReachRate(
                    newList2.getEntry(j)));

                if (newTemp.getReachRate(newList2.getEntry(
                    j)) == -Double.MAX_VALUE) {
                    letter = "reach: N/A";
                }
                System.out.println(letter);
                if (j == newList2.getLength() - 1) {
                    System.out.print("==========");
                }
                else {
                    System.out.println("==========");
                }
            }
        }
        if (showGUI) {

            SortingCalculator mid = new SortingCalculator(filer.getList());
            GUIWindow bron = new GUIWindow(mid);
            
            

        }

    }
}
