package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    @Test
    void mainMethodExit0Test() {
        String[] args = {"-f", "plain",
                TestUtils.getFixturePath("diffFile1.json").toString(),
                TestUtils.getFixturePath("diffFile1.json").toString()};

        CommandLine commandLine = new CommandLine(app);
        int exitCode = commandLine.execute(args);

        assertEquals(0, exitCode);
    }

    @Test
    void mainMethodExit1Test() {
        String[] args = {"-f", "plain",
                TestUtils.getFixturePath("diffFile1.json").toString(),
                TestUtils.getFixturePath("diffFile.json").toString()};

        CommandLine commandLine = new CommandLine(app);
        int exitCode = commandLine.execute(args);

        assertEquals(1, exitCode);
    }
}
