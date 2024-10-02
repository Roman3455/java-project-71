package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    private static String getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize().toString();
    }

    @Test
    public void generateSameFilesTest() throws IOException {
        var filePath1 = getFixturePath("sameFile1.yaml");
        var filePath2 = getFixturePath("sameFile2.yaml");

        String expected = """
                {
                    color: Red
                    fruit: Apple
                    size: 10
                    vegetable: false
                }""";

        String result = Parser.generate(filePath1, filePath2);
        assertEquals(expected, result);
    }

    @Test
    public void generateDifferentFilesTest() throws IOException {
        var filePath1 = getFixturePath("differentFile1.yaml");
        var filePath2 = getFixturePath("differentFile2.yaml");

        String expected = """
                {
                  - follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                  - timeout: 50
                  + timeout: 20
                  + verbose: true
                }""";

        String result = Parser.generate(filePath1, filePath2);
        assertEquals(expected, result);
    }

    @Test
    public void generateWithEmptyFileTest() throws IOException {
        var filePath1 = getFixturePath("differentFile2.yaml");
        var filePath2 = getFixturePath("emptyFile.yaml");

        String expected = """
                {
                  - host: hexlet.io
                  - timeout: 20
                  - verbose: true
                }""";

        String result = Parser.generate(filePath1, filePath2);
        assertEquals(expected, result);
    }
}
