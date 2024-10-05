package hexlet.code.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataUtils {

    public static Set<String> getSetOfKeys(Map<String, Object> dataMap1, Map<String, Object> dataMap2) {
        return Stream
                .concat(dataMap1.keySet().stream(), dataMap2.keySet().stream())
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static Map<String, Object> writeNullAsValue(Map<String, Object> dataMap) {
        dataMap.forEach((key, value) -> {
            if (value == null) {
                dataMap.put(key, "null");
            }
        });
        return dataMap;
    }

    public static List<ChangeRecord> getChangeRecordList(Map<String, Object> dataMap1, Map<String, Object> dataMap2) {
        var setOfKeys = DataUtils.getSetOfKeys(dataMap1, dataMap2);
        var changeRecordList = new ArrayList<ChangeRecord>();

        setOfKeys.forEach(key -> {
            var newValue = dataMap2.getOrDefault(key, null);
            var oldValue = dataMap1.getOrDefault(key, null);
            ChangeRecord changeRecord = getChangeRecord(key, newValue, oldValue);
            changeRecordList.add(changeRecord);
        });

        return changeRecordList;
    }

    private static ChangeRecord getChangeRecord(String key, Object newValue, Object oldValue) {
        ChangeRecord changeRecord;
        if (newValue != null && oldValue != null) {
            changeRecord = newValue.equals(oldValue)
                    ? new ChangeRecord(key, newValue, oldValue, ChangeRecord.State.NONE)
                    : new ChangeRecord(key, newValue, oldValue, ChangeRecord.State.CHANGED);
        } else {
            changeRecord = newValue == null
                    ? new ChangeRecord(key, null, oldValue, ChangeRecord.State.REMOVED)
                    : new ChangeRecord(key, newValue, null, ChangeRecord.State.ADDED);
        }

        return changeRecord;
    }
}
