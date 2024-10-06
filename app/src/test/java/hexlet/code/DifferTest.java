package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void generateDifferentFilesTest() throws Exception {
        TestUtils.checkFormat("diffFile1.json", "diffFile2.json", "diffStylishResult", "stylish");
        TestUtils.checkFormat("diffFile1.json", "diffFile2.json", "diffPlainResult", "plain");
        TestUtils.checkFormat("diffFile1.json", "diffFile2.json", "diffJsonResult", "json");
    }

    @Test
    public void generateWithEmptyFileTest() throws Exception {
        TestUtils.checkFormat("emptyFile.json", "emptyFile.json", "emptyStylishResult", "stylish");
        TestUtils.checkFormat("emptyFile.json", "emptyFile.json", "emptyPlainResult", "plain");
        TestUtils.checkFormat("emptyFile.json", "emptyFile.json", "emptyJsonResult", "json");
    }

    @Test
    public void generateSameFilesTest() throws Exception {
        TestUtils.checkFormat("sameFile.json", "sameFile.json", "sameStylishResult", "stylish");
        TestUtils.checkFormat("sameFile.json", "sameFile.json", "emptyPlainResult", "plain");
        TestUtils.checkFormat("sameFile.json", "sameFile.json", "sameJsonResult", "json");
    }

    @Test
    public void generateWithDefaultFormatTest() throws Exception {
        var actual = Differ.generate(
                TestUtils.getFixturePath("diffFile1.json").toString(),
                TestUtils.getFixturePath("diffFile2.json").toString());
        var expected = Files.readString(TestUtils.getFixturePath("diffStylishResult"));
        assertEquals(expected, actual);
    }
}
