package hexlet.code;

import org.junit.jupiter.api.Test;

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
}
