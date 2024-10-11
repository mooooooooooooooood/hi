package a2_2201040061;

import utils.NotPossibleException;
import java.util.Vector;
import java.util.Scanner;
import static utils.TextIO.getln;
import static utils.TextIO.putln;
import static utils.TextIO.writeFile;
import static utils.TextIO.writeStandardOutput;

public class PCProg {
    private static final Object YES = "Y";

    private Set<PC> objs;

    /**
     * @effects initialise this to have an empty set of PCs
     */
    public PCProg() {
        objs = new Set<>();
    }

    /**
     * @effects create a new PC object using PCFactory and record it in objs
     */
    public void createObjects() throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) { // Loop to create multiple PC objects
            System.out.println("Enter PC details:");
            System.out.println("Model: ");
            String model = sc.nextLine();

            System.out.println("Year: ");
            int year = sc.nextInt();
            sc.nextLine(); // Consume newline character

            System.out.println("Manufacturer: ");
            String manufacturer = sc.nextLine();

            // Create a set of components
            Set<String> components = new Set<>();
            System.out.println("Enter components (enter a blank line to finish):");
            System.out.println("Component: ");
            while (true) {
                String component = sc.nextLine();
                if (component.trim().isEmpty()) {
                    break;
                }
                if (!components.isIn(component)) { //check if comps exits
                    components.insert(component); //add new comp to set
                }
            }

            // Use the factory to create the PC object and add it to objs
            PCFactory factory = PCFactory.getInstance();
            PC newPC = factory.createPC(model, year, manufacturer, components);
            objs.insert(newPC); // Record the PC in the set

            // Ask if the user wants to create another PC object
            System.out.println("Do you want to create another PC? (Y/N)");
            String response = sc.nextLine().trim(); // Get user response
            if (response.equalsIgnoreCase("N")) { // If user says no, break the loop
                break;
            }
        }
    }

    /**
     * @effects return the recorded PC objects
     */
    public Set<PC> getObjects() {
        return objs;
    }

    /**
     * @effects if objs is not empty display to the standard console a text-based
     *          tabular report on objs return this report else display nothing and
     *          return null
     */
    public String displayReport() {
        if (objs.size() > 0) {
            Vector<PC> pcs = objs.getElements();

            PCReport reportObj = new PCReport();
            return reportObj.displayReport(pcs.toArray(new PC[pcs.size()]));
        } else {
            return null;
        }
    }

    /**
     * @effects save report to a file pcs.txt in the same directory as the program's
     */
    public void saveReport(String report) {
        String fileName = "pcs.txt";
        writeFile(fileName);
        putln(report);
        writeStandardOutput();
    }

    /**
     * The run method
     *
     * @effects initialise an instance of PCProg create objects from data entered by
     *          the user display a report on the objects prompt user to save report
     *          to file if user answers "Y" save report else end
     */
    public static void main(String[] args) throws Exception {
        //
        PCProg prog = new PCProg();

        // create objects
        try {
            prog.createObjects();
            // display report
            String report = prog.displayReport();
            System.out.println(report);
            if (report != null) {
                // prompt user to save report
                putln("Save report to file? [Y/N]");
                String toSave = getln();
                if (toSave.equals("Y")) {
                    prog.saveReport(report);
                    putln("report saved");
                }
            }

        } catch (NotPossibleException e) {
            System.err.printf("%s: %s%n", e, e.getMessage());
        }
        putln("~END~");
    }
}