package hexlet.code;

import hexlet.code.formatter.Formatter;
import hexlet.code.utils.DataUtils;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        var dataMap1 = Parser.getDataInMap(filepath1);
        var dataMap2 = Parser.getDataInMap(filepath2);
        var changeRecordList = DataUtils.getChangeRecordList(dataMap1, dataMap2);

        return Formatter.format(format, changeRecordList);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }
}
