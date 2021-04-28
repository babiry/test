package service;

import java.util.List;

import dto.InputCsvParam;
import dto.Sentence;
import dto.TestCsvParam;

/**
 * Test用サービス
 */
public interface TestService {

    /**
     * DBからのデータ取得
     * 
     * @return 取得したデータ
     */
    public List<Sentence> getSentence();
 
    /**
     * DBへのデータ登録
     * 
     */
    public void insertSentence(Sentence sentence);
    
    /**
     * CSVからの取得サンプルサービス
     * 
     * @return CSVから取得したデータ
     */
    public List<TestCsvParam> readCsvSample();

    /**
     * CSVからの取得サンプルサービス
     * 
     * @return CSV空取得したデータ
     */
    public List<InputCsvParam> readCsvTest();

    /**
     * CSVからの書き込みサービス
     * 
     * @param 書き込みデータ
     * @return CSV空取得したデータ
     */
    public boolean writeCsvSample(InputCsvParam input);
}
