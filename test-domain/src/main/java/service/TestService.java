package service;

import java.util.List;

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
	public List<TestCsvParam> sample();
}
