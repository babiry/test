package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor 
public enum LevelItem {
    NUMBER("数字", "01000001"),
    WORD("単語", "01000002");

    private final String label;
    private final String value;
}
