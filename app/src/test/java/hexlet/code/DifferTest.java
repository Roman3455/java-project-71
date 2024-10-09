package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private static String getFixturePath(String filename) {
        return Paths.get("src", "test", "resources", "fixtures", filename)
                .toAbsolutePath().normalize().toString();
    }

    @Test
    public void generateStylishTest() throws Exception {
        var diffFilesActual = Differ.generate(getFixturePath("diffFile1.json"),
                getFixturePath("diffFile2.json"));
        var diffFilesExpected = Files.readString(Paths.get(getFixturePath("diffStylishResult")));
        assertEquals(diffFilesExpected, diffFilesActual);

        var emptyFilesActual = Differ.generate(getFixturePath("emptyFile.json"),
                getFixturePath("emptyFile.json"));
        var emptyFilesExpected = Files.readString(Paths.get(getFixturePath("emptyStylishResult")));
        assertEquals(emptyFilesExpected, emptyFilesActual);

        var sameFilesActual = Differ.generate(getFixturePath("sameFile.json"),
                getFixturePath("sameFile.json"), "stylish");
        var sameFilesExpected = Files.readString(Paths.get(getFixturePath("sameStylishResult")));
        assertEquals(sameFilesExpected, sameFilesActual);
    }

    @Test
    public void generatePlainTest() throws Exception {
        var diffFilesActual = Differ.generate(getFixturePath("diffFile1.json"),
                getFixturePath("diffFile2.json"), "plain");
        var diffFilesExpected = Files.readString(Paths.get(getFixturePath("diffPlainResult")));
        assertEquals(diffFilesExpected, diffFilesActual);

        var emptyFilesActual = Differ.generate(getFixturePath("emptyFile.json"),
                getFixturePath("emptyFile.json"), "plain");
        var emptyFilesExpected = Files.readString(Paths.get(getFixturePath("emptyPlainResult")));
        assertEquals(emptyFilesExpected, emptyFilesActual);

        var sameFilesActual = Differ.generate(getFixturePath("sameFile.json"),
                getFixturePath("sameFile.json"), "plain");
        var sameFilesExpected = Files.readString(Paths.get(getFixturePath("emptyPlainResult")));
        assertEquals(sameFilesExpected, sameFilesActual);
    }

    @Test
    public void generateJsonTest() throws Exception {
        var diffFilesActual = Differ.generate(getFixturePath("diffFile1.json"),
                getFixturePath("diffFile2.json"), "json");
        var diffFilesExpected = Files.readString(Paths.get(getFixturePath("diffJsonResult")));
        assertEquals(diffFilesExpected, diffFilesActual);

        var emptyFilesActual = Differ.generate(getFixturePath("emptyFile.json"),
                getFixturePath("emptyFile.json"), "json");
        var emptyFilesExpected = Files.readString(Paths.get(getFixturePath("emptyJsonResult")));
        assertEquals(emptyFilesExpected, emptyFilesActual);

        var sameFilesActual = Differ.generate(getFixturePath("sameFile.json"),
                getFixturePath("sameFile.json"), "json");
        var sameFilesExpected = Files.readString(Paths.get(getFixturePath("sameJsonResult")));
        assertEquals(sameFilesExpected, sameFilesActual);
    }
}
