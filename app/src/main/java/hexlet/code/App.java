package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")

public class App implements Runnable {

    @Parameters(index = "0", description = "Path to first file.")
    private File filepath1;

    @Parameters(index = "1", description = "Path to second file.")
    private File filepath2;

    @Option(names = {"-f", "--format"}, description = "Output format [default: stylish]", defaultValue = "stylish")
    private String format;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    private boolean helpRequested;

    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    private boolean versionRequested;

    @Override
    public void run() {
        if (versionRequested) {
            System.out.println("gendiff 1.0");
        }
        if (helpRequested) {
            System.out.println("Help information");
        }
    }

    public static void main(String[] args) {
        CommandLine.run(new App(), args);
    }
}
