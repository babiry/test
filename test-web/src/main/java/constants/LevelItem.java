package constants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor 
public enum LevelItem {
    NUMBER("数字", "01000001"),
    WORD("単語", "01000002"),
    NONE("その他", "99999999");

    private final String label;
    private final String value;
    
    public static LevelItem of(String value) {
        for (LevelItem item : LevelItem.values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return NONE;
    }
    
    public static List<LevelItem> allOf(List<String> values) {
        List<LevelItem> levels = new ArrayList<>();
        List<String> items = Stream.of(LevelItem.values()).map(l -> l.getValue()).collect(Collectors.toList());
        for (String value : values) {
            if (items.contains(value)) {
                levels.add(of(value));
            }
        }
        return levels;
    }
}
