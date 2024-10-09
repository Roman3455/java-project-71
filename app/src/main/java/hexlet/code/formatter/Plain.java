package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class Plain {

    public static String output(List<Map<String, Object>> differList) {
        StringBuilder result = new StringBuilder();

        differList.forEach(map -> {
            if (!map.get("state").equals("None")) {
                result.append("Property '")
                        .append(map.get("key"))
                        .append("' was ")
                        .append(
                            switch ((String) map.get("state")) {
                                case "Changed" -> "updated";
                                case "Added" -> "added";
                                default -> "removed";
                            });

                switch ((String) map.get("state")) {
                    case "Changed" -> result.append(". From ")
                            .append(outputValue(map.get("oldValue")))
                            .append(" to ")
                            .append(outputValue(map.get("newValue")))
                            .append("\n");
                    case "Added" -> result.append(" with value: ")
                            .append(outputValue(map.get("newValue")))
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
