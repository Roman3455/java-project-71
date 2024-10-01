package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize().toString();
    }

    @Test
    public void generateSameFilesTest() throws IOException {
        var filePath1 = getFixturePath("sameFile1.json");
        var filePath2 = getFixturePath("sameFile2.json");

        String expected = """
                {
                    color: Red
                    fruit: Apple
                    size: 10
                    vegetable: false
                }""";

        String result = Differ.generate(filePath1, filePath2);
        assertEquals(expected, result);
    }

    @Test
    public void generateDifferentFilesTest() throws IOException {
        var filePath1 = getFixturePath("differentFile1.json");
        var filePath2 = getFixturePath("differentFile2.json");

        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

        String result = Differ.generate(filePath1, filePath2);
        assertEquals(expected, result);
    }

    @Test
    public void generateWithEmptyFileTest() throws IOException {
        var filePath1 = getFixturePath("differentFile2.json");
        var filePath2 = getFixturePath("emptyFile.json");

        String expected = """
                {
                  - host: hexlet.io
                  - timeout: 20
                  - verbose: true
                }""";
    }
}
