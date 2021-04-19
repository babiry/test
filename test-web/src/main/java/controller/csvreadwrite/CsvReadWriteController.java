package controller.csvreadwrite;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import controller.BaseController;
import dto.InputCsvParam;
import dto.TestCsvParam;
import form.SelectForm;
import response.CsvResponse;

@RestController
public class CsvReadWriteController extends BaseController{
  
    @RequestMapping(value = "/csvwirte", method = {GET ,POST})
    public List<CsvResponse> csvwirte(@ModelAttribute SelectForm inputForm,
             BindingResult result, 
            Model model) {
        LOGGER.info("csv write");
        
        if (CollectionUtils.isNotEmpty(inputForm.getLevels())) {
            InputCsvParam input = 
                    new InputCsvParam(
                            createCurrentTime(),inputForm.getLevels().get(0),3);
            testService.writeCsvSample(input);
        }
        List<TestCsvParam> list = testService.readCsvSample();
        model.addAttribute("inputText", inputForm.getLevels().get(0));
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
