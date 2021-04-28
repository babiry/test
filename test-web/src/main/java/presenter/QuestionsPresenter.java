package presenter;

import java.util.ArrayList;
import java.util.List;

import constants.LevelItem;
import constants.RadioItem;
import dto.TestCsvParam;
import form.SelectForm;
import lombok.Getter;

@Getter
public class QuestionsPresenter {
    private List<TestCsvParam> list;
    private SelectForm form;
    private RadioItem itemType;
    private List<LevelItem> level;
    private Integer number;

    public QuestionsPresenter(List<TestCsvParam> list, SelectForm form) {

        this.form = form;
        this.itemType = RadioItem.of(form.getQuestionType());
        this.level = LevelItem.allOf(form.getLevels());
        this.number = form.getQuestionNumber() == null ? 10
                : form.getQuestionNumber();
        this.list = createQuestion(list);
    }

    private List<TestCsvParam> createQuestion(List<TestCsvParam> list) {
        List<TestCsvParam> questions = new ArrayList<>();

        for (int i = 0; i <= number; i++) {
            if (itemType.isProblem()) {
                questions.add(new TestCsvParam(list.get(i).getParam(),
                        list.get(i).getValue(), list.get(i).getNum()));
            } else {
                questions.add(new TestCsvParam(list.get(i).getValue(),
                        list.get(i).getValue(), list.get(i).getNum()));
            }
        }

        return questions;
    }
}
