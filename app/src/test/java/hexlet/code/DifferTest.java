package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void generateDifferentFilesTest() throws IOException {
        String actualStylishJson = TestUtils.getActual("diffJsonFile1.json", "diffJsonFile2.json", "stylish");
        String actualStylishYaml = TestUtils.getActual("diffYamlFile1.yaml", "diffYamlFile2.yaml");
        String expectedStylish = TestUtils.getExpected("diffStylishResult");
        assertEquals(expectedStylish, actualStylishJson);
        assertEquals(expectedStylish, actualStylishYaml);

        String actualPlainJson = TestUtils.getActual("diffJsonFile1.json", "diffJsonFile2.json", "plain");
        String actualPlainYaml = TestUtils.getActual("diffYamlFile1.yaml", "diffYamlFile2.yaml", "plain");
        String expectedPlain = TestUtils.getExpected("diffPlainResult");
        assertEquals(expectedPlain, actualPlainJson);
        assertEquals(expectedPlain, actualPlainYaml);
    }

    @Test
    public void generateWithEmptyFileTest() throws IOException {
        String actualStylishJson = TestUtils.getActual("emptyJsonFile.json", "emptyJsonFile.json");
        String actualStylishYaml = TestUtils.getActual("emptyYamlFile.yaml", "emptyYamlFile.yaml", "stylish");
        String expectedStylish = TestUtils.getExpected("emptyStylishResult");
        assertEquals(expectedStylish, actualStylishJson);
        assertEquals(expectedStylish, actualStylishYaml);

        String actualPlainJson = TestUtils.getActual("emptyJsonFile.json", "emptyJsonFile.json", "plain");
        String actualPlainYaml = TestUtils.getActual("emptyYamlFile.yaml", "emptyYamlFile.yaml", "plain");
        String expectedPlain = TestUtils.getExpected("emptyPlainResult");
        assertEquals(expectedPlain, actualPlainJson);
        assertEquals(expectedPlain, actualPlainYaml);
    }

    @Test
    public void generateSameFilesTest() throws IOException {
        String actualStylishJson = TestUtils.getActual("sameJsonFile.json", "sameJsonFile.json");
        String actualStylishYaml = TestUtils.getActual("sameYamlFile.yaml", "sameYamlFile.yaml");
        String expectedStylish = TestUtils.getExpected("sameStylishResult");
        assertEquals(expectedStylish, actualStylishJson);
        assertEquals(expectedStylish, actualStylishYaml);

        String actualPlainJson = TestUtils.getActual("sameJsonFile.json", "sameJsonFile.json", "plain");
        String actualPlainYaml = TestUtils.getActual("sameYamlFile.yaml", "sameYamlFile.yaml", "plain");
        String expectedPlain = TestUtils.getExpected("emptyPlainResult");
        assertEquals(expectedPlain, actualPlainJson);
        assertEquals(expectedPlain, actualPlainYaml);
    }
}
