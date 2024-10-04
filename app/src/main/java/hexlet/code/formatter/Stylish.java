package hexlet.code.formatter;

import hexlet.code.utils.DataDifference;

import java.util.List;

public class Stylish {
    private static final String NONE = "    ";
    private static final String REMOVED = "  - ";
    private static final String ADDED = "  + ";

    public static String output(List<DataDifference> listOfDifferences) {
        StringBuilder result = new StringBuilder("{\n");
        listOfDifferences.forEach(key -> {
            if (key.state().equals(DataDifference.State.NONE)) {
                result.append(NONE).append(key.key()).append(": ")
                        .append(key.newValue().toString()).append("\n");
            }
            if (key.state().equals(DataDifference.State.REMOVED)) {
                result.append(REMOVED).append(key.key()).append(": ")
                        .append(key.oldValue().toString()).append("\n");
            }
            if (key.state().equals(DataDifference.State.ADDED)) {
                result.append(ADDED).append(key.key()).append(": ")
                        .append(key.newValue().toString()).append("\n");
            }
            if (key.state().equals(DataDifference.State.CHANGED)) {
                result.append(REMOVED).append(key.key()).append(": ")
                        .append(key.oldValue().toString()).append("\n");
                result.append(ADDED).append(key.key()).append(": ")
                        .append(key.newValue().toString()).append("\n");
            }
        });
        result.append("}");

        return result.toString();
    }
}
