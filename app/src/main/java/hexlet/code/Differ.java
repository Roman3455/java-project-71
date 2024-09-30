package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws IOException {

        var fileContent1 = Files.readString(Paths.get(filePath1));
        var fileContent2 = Files.readString(Paths.get(filePath2));

        var firstDataMap = getData(fileContent1);
        var secondDataMap = getData(fileContent2);
        var unitedData = new TreeMap<>(firstDataMap);
        unitedData.putAll(secondDataMap);

        StringBuilder result = new StringBuilder("{\n");
        for (var entry : unitedData.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            var containsFirstData = firstDataMap.containsKey(key);
            var containsSecondData = secondDataMap.containsKey(key);

            if (containsFirstData && containsSecondData && firstDataMap.get(key).equals(secondDataMap.get(key))) {
                result.append("    " + key + ": " + value.toString() + "\n");
            } else {
                if (containsFirstData) {
                    result.append("  - " + key + ": " + value.toString() + "\n");
                }
                if (containsSecondData) {
                    result.append("  + " + key + ": " + value.toString() + "\n");
                }
            }
        }
        result.append("}");

        return result.toString();
    }

    public static Map<String, Object> getData(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
    }
}
