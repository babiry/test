package service;

import java.util.List;

import dto.InputCsvParam;
import dto.TestCsvParam;

/**
 * Test用サービス
 */
public interface TestService {

    /**
     * CSVからの取得サンプルサービス
     * 
     * @return CSV空取得したデータ
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
