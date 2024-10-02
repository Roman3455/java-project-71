package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Parser {

    public static String generate(String filepath1, String filepath2) throws IOException {
        var fileContent1 = Files.readString(Paths.get(filepath1));
        var fileContent2 = Files.readString(Paths.get(filepath2));

        var firstDataMap = getData(fileContent1);
        var secondDataMap = getData(fileContent2);
        var unitedData = new TreeMap<>(firstDataMap);
        unitedData.putAll(secondDataMap);

        StringBuilder result = new StringBuilder("{\n");
        for (var entry : unitedData.entrySet()) {
            var key = entry.getKey();
            var containsFirstData = firstDataMap.containsKey(key);
            var containsSecondData = secondDataMap.containsKey(key);

            if (containsFirstData && containsSecondData && firstDataMap.get(key).equals(secondDataMap.get(key))) {
                result.append("    " + key + ": " + entry.getValue().toString() + "\n");
            } else {
                if (containsFirstData) {
                    result.append("  - " + key + ": " + firstDataMap.get(key).toString() + "\n");
                }
                if (containsSecondData) {
                    result.append("  + " + key + ": " + secondDataMap.get(key).toString() + "\n");
                }
            }
        }
        result.append("}");

        return result.toString();
    }

    private static Map<String, Object> getData(String content) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(content, Map.class);
    }
}
