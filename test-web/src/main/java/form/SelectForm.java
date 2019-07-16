package form;

import java.util.List;

import lombok.Data;

@Data
public class SelectForm {
    // 出題種別
    private String questionType;
    // 問題数
    private Integer questionNumber;
    // 出題レベル(キー値)
    private List<String> levels;
}
