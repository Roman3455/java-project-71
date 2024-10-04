package hexlet.code;

import hexlet.code.formatter.Formatter;
import hexlet.code.utils.DataDifference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws IOException {

        var dataMap1 = Parser.getDataInMap(filepath1);
        var dataMap2 = Parser.getDataInMap(filepath2);

        var listOfDifferences = getListOfDifferences(dataMap1, dataMap2);

        return Formatter.format(format, listOfDifferences);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }

    private static List<DataDifference> getListOfDifferences(Map<String, Object> dataMap1, Map<String,
            Object> dataMap2) {
        var setOfData = getSetOfData(dataMap1, dataMap2);
        var listOfDifferences = new ArrayList<DataDifference>();

        setOfData.forEach(key -> {
            var newValue = dataMap2.getOrDefault(key, null);
            var oldValue = dataMap1.getOrDefault(key, null);

            DataDifference dataStorage;
            if (newValue == null) {
                dataStorage = new DataDifference(key, null, oldValue, DataDifference.State.REMOVED);
            } else if (oldValue == null) {
                dataStorage = new DataDifference(key, newValue, null, DataDifference.State.ADDED);
            } else if (newValue.equals(oldValue)) {
                dataStorage = new DataDifference(key, newValue, oldValue, DataDifference.State.NONE);
            } else {
                dataStorage = new DataDifference(key, newValue, oldValue, DataDifference.State.CHANGED);
            }
            listOfDifferences.add(dataStorage);
        });

        return listOfDifferences;
    }

    private static Set<String> getSetOfData(Map<String, Object> dataMap1, Map<String, Object> dataMap2) {
        return Stream
                .concat(dataMap1.keySet().stream(), dataMap2.keySet().stream())
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
