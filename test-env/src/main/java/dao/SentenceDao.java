package dao;

import java.util.List;

import dto.Sentence;

/**
 * 文章Dao
 */
public interface SentenceDao {

    /**
     * 対象のデータ取得
     */
    public Sentence getSentence(String id);
    
    /**
     * 一覧取得
     */
    public List<Sentence> getSentences();

    /**
     * 登録
     */
    public void insert(Sentence sentence);
    
    /**
     * 更新
     * 
     * @return 更新結果
     */
    public boolean update(Sentence sentence);
}
