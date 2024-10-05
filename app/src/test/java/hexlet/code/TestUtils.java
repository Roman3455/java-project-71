package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtils {

    protected static String getActual(String filename1, String filename2, String format) throws IOException {
        var filepath1 = getFixturePath(filename1).toString();
        var filepath2 = getFixturePath(filename2).toString();
        return Differ.generate(filepath1, filepath2, format);
    }

    protected static String getActual(String filename1, String filename2) throws IOException {
        return getActual(filename1, filename2, "stylish");
    }

    protected static String getExpected(String filename) throws IOException {
        var filepath = getFixturePath(filename);
        return Files.readString(filepath);
    }

    protected static Path getFixturePath(String filename) {
        return Paths.get("src", "test", "resources", "fixtures", filename)
                .toAbsolutePath().normalize();
    }
}
