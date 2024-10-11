package a2_2201040061;

public class PCReport {
        /**
         * Generates a report string based on the provided array of PC objects.
         *
         * @param objs An array of PC objects.
         * @return A formatted report string.
         */
        public static String displayReport(PC[] objs) {
            StringBuilder report = new StringBuilder();

            report.append("---------------------------------------------------------------------------------------------------\n");
            report.append("                                           PCPROG REPORT                                           \n");
            report.append("---------------------------------------------------------------------------------------------------\n");

            // Maximum length for components string
            int maxComponentLength = 50;

            for (int i = 0; i < objs.length; i++) {
                PC pc = objs[i];
                String components = limitedStringSetLength(pc.getComps().toString(), maxComponentLength);

                report.append(String.format(" %-3d %-20s %-4d %15s %-30s \n", i + 1, pc.getModel(), pc.getYear(), pc.getManufacturer(), components));
            }

            report.append("---------------------------------------------------------------------------------------------------\n");

            return report.toString(); // Return the generated report
        }



    public static String limitedStringSetLength(String str, int maxLength) {
        if (str.length() <= maxLength) {
            return str;
        } else {
            return str.substring(0, maxLength - 3) + "...]";
        }
    }
}
