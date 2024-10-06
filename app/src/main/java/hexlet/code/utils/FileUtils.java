package hexlet.code.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {
    // todo Список создан для предполагаемого расширения форматов (как будет реализовано расширение?)
    private static final List<String> ACCEPTABLE_EXTENSIONS = List.of("json", "yaml", "yml");

    public static Path getAbsolutePath(String filepath) throws IOException {
        if (filepath == null || filepath.trim().isEmpty()) {
            throw new IOException("Filepath not specified");
        }
        Path absolutePath = FileSystems.getDefault().getPath(filepath.trim()).toAbsolutePath().normalize();

        if (!Files.exists(absolutePath)) {
            throw new FileNotFoundException("File or directory not found");
        }
        return absolutePath;
    }

    public static String getContentAsString(String filepath) throws IOException {
        var absolutePath = getAbsolutePath(filepath);
        return Files.readString(absolutePath);
    }

    public static String getExtension(String filepath) throws IOException {
        var filenameParts = getAbsolutePath(filepath).getFileName().toString().split("\\.");
        var extension = filenameParts[filenameParts.length - 1];

        if (!ACCEPTABLE_EXTENSIONS.contains(extension)) {
            throw new IllegalArgumentException("File format is not supported");
        }

        return extension;
    }
}
