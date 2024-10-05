package hexlet.code.formatter;

import hexlet.code.utils.ChangeRecord;

import java.util.List;

public class Stylish {
    private static final String NONE = "    ";
    private static final String REMOVED = "  - ";
    private static final String ADDED = "  + ";

    public static String output(List<ChangeRecord> listOfDifferences) {
        StringBuilder result = new StringBuilder("{\n");

        listOfDifferences.forEach(key -> {
            switch (key.state()) {
                case NONE:
                    appendChange(result, NONE, key.key(), key.newValue());
                    break;
                case REMOVED:
                    appendChange(result, REMOVED, key.key(), key.oldValue());
                    break;
                case ADDED:
                    appendChange(result, ADDED, key.key(), key.newValue());
                    break;
                default:
                    appendChange(result, REMOVED, key.key(), key.oldValue());
                    appendChange(result, ADDED, key.key(), key.newValue());
            }
        });
        result.append("}");
        return result.toString();
    }

    private static void appendChange(StringBuilder result, String prefix, String key, Object value) {
        result.append(prefix)
                .append(key)
                .append(": ")
                .append(value.toString())
                .append("\n");
    }
}
