package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor 
public enum RadioItem {
    PROBLEM("問題", "problem"),
    PRACTICE("練習", "practice");

    private final String label;
    private final String value;
}
