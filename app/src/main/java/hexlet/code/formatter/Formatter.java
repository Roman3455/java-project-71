package hexlet.code.formatter;

import hexlet.code.utils.ChangeRecord;

import java.util.List;

public class Formatter {
    public static String format(String format, List<ChangeRecord> listOfDifferences) {
        if (format.equals("stylish")) {
            return Stylish.output(listOfDifferences);
        } else {
            return Plain.output(listOfDifferences);
        }
    }
}
