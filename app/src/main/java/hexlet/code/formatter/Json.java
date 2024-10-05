package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.utils.ChangeRecord;

import java.util.List;

public class Json {
    public static String output(List<ChangeRecord> listOfDifferences) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(listOfDifferences);
    }
}
