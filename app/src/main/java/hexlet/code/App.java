package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0", separator = ":",
        description = "Compares two configuration files and shows a difference.")

public class App implements Callable<String> {

    @Option(names = {"-f", "--format"}, description = "Output format @|italic [default: stylish]|@",
            defaultValue = "stylish")
    private String format;

    @Parameters(index = "0", description = "Path to first file.")
    private String filepath1;

    @Parameters(index = "1", description = "Path to second file.")
    private String filepath2;

    @Override
    public String call() throws IOException {
        try {
            System.out.println(Differ.generate(filepath1, filepath2));
            System.out.println(Parser.generate(filepath1, filepath2));
            return "0";
        } catch (Exception e) {
            System.out.println("File does not exist or the filepath is incorrect");
            return "1";
        }
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
