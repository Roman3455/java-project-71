package hexlet.code.formatter;

import hexlet.code.utils.ChangeRecord;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String output(List<ChangeRecord> listOfDifferences) {
        StringBuilder result = new StringBuilder();

        listOfDifferences.forEach(key -> {
            if (!key.state().equals(ChangeRecord.State.NONE)) {
                result.append("Property '")
                        .append(key.key())
                        .append("' was ")
                        .append(
                            switch (key.state()) {
                                case CHANGED -> "updated";
                                case ADDED -> "added";
                                default -> "removed";
                            });
                switch (key.state()) {
                    case CHANGED -> result.append(". From ")
                            .append(outputValue(key.oldValue()))
                            .append(" to ")
                            .append(outputValue(key.newValue()))
                            .append("\n");
                    case ADDED -> result.append(" with value: ")
                            .append(outputValue(key.newValue()))
                            .append("\n");
                    default -> result.append("\n");
                }
            }
        });

        if (!result.isEmpty()) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    private static Object outputValue(Object type) {
        if (type instanceof List<?> || type instanceof Map<?, ?>) {
            return "[complex value]";
        }
        if (type instanceof String && !type.equals("null")) {
            return "'" + type + "'";
        }
        return type;
    }
}
