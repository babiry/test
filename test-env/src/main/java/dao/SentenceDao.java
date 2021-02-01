package dao;

import java.util.List;

import dto.Sentence;

/**
 * Test用サービス
 */
public interface SentenceDao {

    /**
     * CSVからの取得サンプルサービス
     * 
     * @return CSV空取得したデータ
     */
    public List<Sentence> getSentences();

}
