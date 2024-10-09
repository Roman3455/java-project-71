package hexlet.code;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        var dataMap1 = Parser.parse(filepath1);
        var dataMap2 = Parser.parse(filepath2);

        var differList = DiffBuilder.generate(dataMap1, dataMap2);

        return Formatter.format(format, differList);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
