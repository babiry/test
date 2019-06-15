package util;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import dto.InputCsvParam;
import dto.TestCsvParam;

@Component
public class ConvertCsvToDto {

    /**
     * StringのリストからTestCsvParamのリストへ変換
     * 
     * @return CSVのList
     */
    public List<TestCsvParam> createTestCsvParams(List<String> csv) {
        return csv.stream().filter(c -> StringUtils.isNoneEmpty(c))
                .map(c -> createTestCsvParam(c)).collect(Collectors.toList());
    }

    /**
     * StringからTestCsvParamへ変換
     * 
     * @return CSVの1行
     */
    private TestCsvParam createTestCsvParam(String str) {
        String[] data = str.split(",");
        return new TestCsvParam(data[0], data[1], NumberUtils.toInt(data[2]));
    }

    /**
     * StringのリストからTestCsvParamのリストへ変換
     * 
     * @return CSVのList
     */
    public List<InputCsvParam> createInputCsvParams(List<String> csv) {
        return csv.stream().filter(c -> StringUtils.isNoneEmpty(c))
                .map(c -> createInputCsvParam(c)).collect(Collectors.toList());
    }

    /**
     * StringからTestCsvParamへ変換
     * 
     * @return CSVの1行
     */
    private InputCsvParam createInputCsvParam(String str) {
        String[] data = str.split(",");
        return new InputCsvParam(data[0], data[1], NumberUtils.toInt(data[2]));
    }
}
