package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csv.CsvFileReadSample;
import dto.TestCsvParam;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private CsvFileReadSample csvFileReadSample;

	@Override
	public List<TestCsvParam> sample() {
		return csvFileReadSample.getTestCsv();
	}
}
