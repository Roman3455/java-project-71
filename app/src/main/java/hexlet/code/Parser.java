package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.utils.DataUtils;
import hexlet.code.utils.FileUtils;

import java.io.IOException;
import java.util.Map;

public class Parser {
    // todo как будет производиться расширение под новые форматы в реальных проектах
    public static Map<String, Object> getDataInMap(String filepath) throws IOException {

        var extension = FileUtils.getExtension(filepath);
        var content = FileUtils.getContentAsString(filepath);

        ObjectMapper objectMapper;
        objectMapper = switch (extension) {
            case "json" -> new ObjectMapper();
            default -> new ObjectMapper(new YAMLFactory());
        };
        var dataMap = objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });

        return DataUtils.writeNullAsValue(dataMap);
    }
}
