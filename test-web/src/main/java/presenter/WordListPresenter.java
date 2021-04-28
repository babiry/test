package presenter;

import java.util.List;

import dto.Sentence;
import lombok.Getter;

@Getter
public class WordListPresenter {
    private List<Sentence> list;

    public WordListPresenter(List<Sentence> list) {

        // 先頭にタイトルを追加
        list.add(0,new Sentence("id","answer","word"));
        this.list = list;
    }
}
