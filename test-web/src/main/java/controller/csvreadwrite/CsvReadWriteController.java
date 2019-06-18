package controller.csvreadwrite;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.InputCsvParam;
import dto.TestCsvParam;
import form.InputForm;
import response.CsvResponse;
import service.TestService;

@RestController
public class CsvReadWriteController {

    @Autowired
    private TestService testService;

    private Logger LOGGER = LogManager.getLogger();
  
    @RequestMapping(value = "/csvwirte", method = {GET ,POST})
    public List<CsvResponse> greeting(@ModelAttribute InputForm inputForm,
             BindingResult result, 
            Model model) {
        LOGGER.info("csv write");
        
        if (StringUtils.isNotEmpty(inputForm.getTextValue())) {
            InputCsvParam input = 
                    new InputCsvParam(
                            createCurrentTime(),inputForm.getTextValue(),3);
            testService.writeCsvSample(input);
        }
        List<TestCsvParam> list = testService.readCsvSample();
        model.addAttribute("inputText", inputForm.getTextValue());
        model.addAttribute("paramlist", list);

        List<InputCsvParam> list2  = testService.readCsvTest();
        model.addAttribute("testlist", list2);
        CsvResponse res = new CsvResponse();
        res.setValue("test");
        res.setCount(99);
        return Arrays.asList(res);
    }
    
    private String createCurrentTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
