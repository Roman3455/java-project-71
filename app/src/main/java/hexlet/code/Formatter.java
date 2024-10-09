package hexlet.code;

import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String format(String format, List<Map<String, Object>> differList) throws Exception {
        switch (format) {
            case "stylish" -> {
                return Stylish.output(differList);
            }
            case "plain" -> {
                return Plain.output(differList);
            }
            case "json" -> {
                return Json.output(differList);
            }
            default -> throw new Exception("Format: " + format + " not supported");
        }
    }
}
