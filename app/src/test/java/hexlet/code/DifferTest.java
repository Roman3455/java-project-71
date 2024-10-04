package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String getActual(String filename1, String filename2) throws IOException {
        var filepath1 = getFixturePath(filename1).toString();
        var filepath2 = getFixturePath(filename2).toString();
        return Differ.generate(filepath1, filepath2);
    }

    private static String getExpected(String filename) throws IOException {
        var filepath = getFixturePath(filename);
        return Files.readString(filepath);
    }

    private static Path getFixturePath(String filename) {
        return Paths.get("src", "test", "resources", "fixtures", filename)
                .toAbsolutePath().normalize();
    }

    @Test
    public void generateSameFilesTest() throws IOException {
        String actualJson = getActual("sameJsonFile1.json", "sameJsonFile2.json");
        String actualYaml = getActual("sameYamlFile1.yaml", "sameYamlFile2.yaml");
        String expected = getExpected("sameStylishResult");
        assertEquals(expected, actualJson);
        assertEquals(expected, actualYaml);
    }

    @Test
    public void generateDifferentFilesTest() throws IOException {
        String actualJson = getActual("diffJsonFile1.json", "diffJsonFile2.json");
        String actualYaml = getActual("diffYamlFile1.yaml", "diffYamlFile2.yaml");
        String expected = getExpected("diffStylishResult");
        assertEquals(expected, actualJson);
        assertEquals(expected, actualYaml);
    }

    @Test
    public void generateWithEmptyFileTest() throws IOException {
        String actualJson = getActual("emptyJsonFile.json", "emptyJsonFile.json");
        String actualYaml = getActual("emptyYamlFile.yaml", "emptyYamlFile.yaml");
        String expected = getExpected("emptyStylishResult");
        assertEquals(expected, actualJson);
        assertEquals(expected, actualYaml);
    }
}
