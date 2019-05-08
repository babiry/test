package csv;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import dto.TestCsvParam;

@Component
public class CsvFileReadSample {

	private static final String PATH = "../test-env/src/main/resources/";
	private static final String TEST_CSV_FILE_NAME = "test.csv";
	private static final String CHARSET = "UTF-8";

	/**
	 * Csvからのデータ取得
	 * 
	 * @return 読み込んだCSVList
	 */
	public List<TestCsvParam> getTestCsv() {
		try {
			return createTestCsv(Files.readAllLines(Paths.get(PATH + TEST_CSV_FILE_NAME), Charset.forName(CHARSET)));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * StringのリストからTestCsvParamのリストへ変換
	 * 
	 * @return CSVのList
	 */
	private List<TestCsvParam> createTestCsv(List<String> csv) {
		return csv.stream().filter(c -> StringUtils.isNoneEmpty(c)).map(c -> createParam(c))
		        .collect(Collectors.toList());
	}

	/**
	 * StringからTestCsvParamへ変換
	 * 
	 * @return CSVの1行
	 */
	private TestCsvParam createParam(String str) {
		String[] data = str.split(",");
		return new TestCsvParam(data[0], data[1], NumberUtils.toInt(data[2]));
	}
}
