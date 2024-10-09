package hexlet.code.formatter;

import java.util.List;
import java.util.Map;

public class Stylish {
    private static final String NONE = "    ";
    private static final String REMOVED = "  - ";
    private static final String ADDED = "  + ";

    public static String output(List<Map<String, Object>> differList) {
        StringBuilder result = new StringBuilder("{\n");

        differList.forEach(map -> {
            var state = (String) map.get("state");

            switch (state) {
                case "None":
                    appendChange(result, NONE, map.get("key"), map.get("newValue"));
                    break;
                case "Removed":
                    appendChange(result, REMOVED, map.get("key"), map.get("oldValue"));
                    break;
                case "Added":
                    appendChange(result, ADDED, map.get("key"), map.get("newValue"));
                    break;
                default:
                    appendChange(result, REMOVED, map.get("key"), map.get("oldValue"));
                    appendChange(result, ADDED, map.get("key"), map.get("newValue"));
            }
        });
        result.append("}");

        return result.toString();
    }

    private static void appendChange(StringBuilder result, String prefix, Object key, Object value) {
        result.append(prefix)
                .append(key)
                .append(": ")
                .append(value)
                .append("\n");
    }
}
