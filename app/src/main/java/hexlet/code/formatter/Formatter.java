package hexlet.code.formatter;

import hexlet.code.utils.ChangeRecord;

import java.util.List;

public class Formatter {
    public static String format(String format, List<ChangeRecord> listOfDifferences) throws Exception {
        switch (format) {
            case "stylish" -> {
                return Stylish.output(listOfDifferences);
            }
            case "plain" -> {
                return Plain.output(listOfDifferences);
            }
            case "json" -> {
                return Json.output(listOfDifferences);
            }
            default -> throw new Exception("Format: " + format + " not supported");
        }
    }
}
