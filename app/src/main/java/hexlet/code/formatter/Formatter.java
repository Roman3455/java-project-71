package hexlet.code.formatter;

import hexlet.code.utils.DataDifference;

import java.util.List;

public class Formatter {
    public static String format(String format, List<DataDifference> listOfDifferences) {
        if (format.equals("stylish")) {
            return Stylish.output(listOfDifferences);
        } else {
            return "22";
        }
    }
}
