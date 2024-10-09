package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DiffBuilder {

    public static List<Map<String, Object>> generate(Map<String, Object> dataMap1, Map<String, Object> dataMap2) {
        var setOfKeys = new TreeSet<>(dataMap1.keySet());
        setOfKeys.addAll(dataMap2.keySet());

        var differList = new ArrayList<Map<String, Object>>();
        setOfKeys.forEach(key -> {
            var diff = new HashMap<String, Object>();
            diff.put("key", key);

            boolean hasOldValue = dataMap1.containsKey(key);
            boolean hasNewValue = dataMap2.containsKey(key);

            if (hasOldValue && hasNewValue) {
                var oldVal = dataMap1.get(key);
                var newVal = dataMap2.get(key);
                diff.put("oldValue", oldVal);
                diff.put("newValue", newVal);

                if (oldVal == null || newVal == null) {
                    diff.put("state", oldVal == newVal ? "None" : "Changed");
                } else {
                    diff.put("state", oldVal.equals(newVal) ? "None" : "Changed");
                }

            } else {
                if (!hasOldValue) {
                    diff.put("newValue", dataMap2.get(key));
                    diff.put("state", "Added");
                }

                if (!hasNewValue) {
                    diff.put("oldValue", dataMap1.get(key));
                    diff.put("state", "Removed");
                }
            }
            differList.add(diff);
        });

        return differList;
    }
}
