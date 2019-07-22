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
    
    public static RadioItem of(String value) {
        for (RadioItem item : RadioItem.values()) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return PROBLEM;
    }
    
    public boolean isProblem() {
        return PROBLEM == this;
    }
}
