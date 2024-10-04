package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.utils.FileUtils;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getDataInMap(String filepath) throws IOException {
        var extension = FileUtils.getExtension(filepath);
        var content = FileUtils.getFileAsString(filepath);

        ObjectMapper objectMapper;
        objectMapper = switch (extension) {
            case "json" -> new ObjectMapper();
            default -> new ObjectMapper(new YAMLFactory());
        };

        var dataMap = objectMapper.readValue(content, Map.class);
        return replaceNullValue(dataMap);
    }

    private static Map<String, Object> replaceNullValue(Map<String, Object> dataMap) {
        dataMap.forEach((key, value) -> {
            if (value == null) {
                dataMap.put(key, "null");
            }
        });
        return dataMap;
    }
}
