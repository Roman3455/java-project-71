package hexlet.code.utils;
// todo RecordClass?
public record ChangeRecord(String key,
                           Object newValue,
                           Object oldValue,
                           ChangeRecord.State state) {
    public enum State {
        NONE, REMOVED, ADDED, CHANGED
    }
}
