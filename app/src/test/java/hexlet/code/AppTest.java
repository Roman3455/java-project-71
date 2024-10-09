package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class AppTest {
    private App app;

    @BeforeEach
    void setUp() {
        app = new App();
    }

    private static String getFixturePath(String filename) {
        return Paths.get("src", "test", "resources", "fixtures", filename)
                .toAbsolutePath().normalize().toString();
    }

    @Test
    void mainMethodExit0Test() {
        String[] args = {"-f", "plain",
                getFixturePath("diffFile1.json"),
                getFixturePath("diffFile1.json")};

        CommandLine commandLine = new CommandLine(app);
        int exitCode = commandLine.execute(args);

        assertEquals(0, exitCode);
    }

    @Test
    void mainMethodExit1Test() {
        String[] args = {"-f", "plain",
                getFixturePath("diffFile1.json"),
                getFixturePath("diffFile.json")};

        CommandLine commandLine = new CommandLine(app);
        int exitCode = commandLine.execute(args);

        assertEquals(1, exitCode);
    }
}
