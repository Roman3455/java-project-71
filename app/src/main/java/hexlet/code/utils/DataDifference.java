package hexlet.code.utils;

// todo вопрос наименования и расширения класса для хранения новых данных в продак.
// todo RecordClass?
public record DataDifference(String key, Object newValue, Object oldValue,
                             hexlet.code.utils.DataDifference.State state) {
    public enum State {
        NONE, REMOVED, ADDED, CHANGED
    }
}
