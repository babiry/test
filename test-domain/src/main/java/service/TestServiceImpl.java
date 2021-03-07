package service;

import static constants.CsvConstants.SAMPLE_CSV_FILE_NAME;
import static constants.CsvConstants.TEST_CSV_FILE_NAME;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csv.CsvFileReadSample;
import csv.CsvFileWriteSample;
import dao.SentenceDao;
import dto.InputCsvParam;
import dto.Sentence;
import dto.TestCsvParam;
import util.ConvertCsvToDto;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private CsvFileReadSample csvFileReadSample;

    @Autowired
    private CsvFileWriteSample csvFileWriteSample;

    @Autowired
    private SentenceDao sentenceDao;

    @Autowired
    private  ConvertCsvToDto convert;

    @Override
    public List<TestCsvParam> readCsvSample() {
        return convert.createTestCsvParams(sentenceDao.getSentences());
    }
    
    @Override
    public List<InputCsvParam> readCsvTest() {
        List<String> csvData = 
                csvFileReadSample.getTestCsv(TEST_CSV_FILE_NAME);
        return convert.createInputCsvParams(csvData);
    }
    @Override
    public boolean writeCsvSample(InputCsvParam input) {
        StringJoiner writeData = new StringJoiner(",");
        // TODO ラムダ式の中にtry/catchがあつると見づらい例
        Arrays.asList(input.getClass().getDeclaredFields())
        .forEach(f -> {
            try {
                f.setAccessible(true);
                writeData.add(f.get(input).toString());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return csvFileWriteSample.writeCsv(writeData.toString());
    }
}
