package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Parser {
    private static final List<String> ACCEPTABLE_EXTENSIONS = List.of("json", "yaml", "yml");

    public static Map<String, Object> parse(String filepath) throws IOException {

        Path absolutePath = FileSystems.getDefault().getPath(filepath.trim()).toAbsolutePath().normalize();
        if (!Files.exists(absolutePath)) {
            throw new FileNotFoundException("File or directory not found");
        }

        var filename = absolutePath.getFileName().toString().split("\\.");

        var extension = filename[filename.length - 1];
        if (!ACCEPTABLE_EXTENSIONS.contains(extension)) {
            throw new IllegalArgumentException("File format is not supported");
        }

        var content = Files.readString(absolutePath);

        ObjectMapper objectMapper;
        objectMapper = switch (extension) {
            case "json" -> new ObjectMapper();
            default -> new ObjectMapper(new YAMLFactory());
        };

        return objectMapper.readValue(content, new TypeReference<>() {
        });
    }
}
