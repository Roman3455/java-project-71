package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUtils {

    protected static void checkFormat(String filename1, String filename2, String expectedResult, String format)
            throws Exception {
        String actualJson = TestUtils.getActual(filename1, filename2, format);
        String actualYaml = TestUtils.getActual(
                filename1.replace(".json", ".yaml"),
                filename2.replace(".json", ".yaml"),
                format);
        String expected = TestUtils.getExpected(expectedResult);

        assertEquals(expected, actualJson);
        assertEquals(expected, actualYaml);
    }

    protected static String getActual(String filename1, String filename2, String format) throws Exception {
        var filepath1 = getFixturePath(filename1).toString();
        var filepath2 = getFixturePath(filename2).toString();
        return Differ.generate(filepath1, filepath2, format);
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
