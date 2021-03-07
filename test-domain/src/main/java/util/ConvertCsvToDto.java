package util;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Component;

import dto.InputCsvParam;
import dto.Sentence;
import dto.TestCsvParam;

@Component
public class ConvertCsvToDto {

    /**
     * リストからTestCsvParamのリストへ変換
     * 
     * @return CSVのList
     */
    public List<TestCsvParam> createTestCsvParamsFromStr(List<String> csv) {
        return csv.stream().filter(c -> StringUtils.isNotEmpty(c))
                .map(c -> createTestCsvParam(c)).collect(Collectors.toList());
    }
    
    /**
     * リストからTestCsvParamのリストへ変換
     * 
     * @return CSVのList
     */
    public List<TestCsvParam> createTestCsvParams(List<Sentence> csv) {
        return csv.stream().filter(c -> StringUtils.isNotEmpty(c.getAnswer()))
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
     * StringからTestCsvParamへ変換
     * 
     * @return CSVの1行
     */
    private TestCsvParam createTestCsvParam(Sentence str) {
        return new TestCsvParam(str.getWord(), str.getAnswer(),1);
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
