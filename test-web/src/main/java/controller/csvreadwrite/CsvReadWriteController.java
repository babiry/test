package controller.csvreadwrite;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.InputCsvParam;
import dto.TestCsvParam;
import form.InputForm;
import service.TestService;

@Controller
public class CsvReadWriteController {

    @Autowired
    private TestService testService;

    private Logger LOGGER = LogManager.getLogger();
  
    @RequestMapping(value = "/greeting", method = {GET ,POST})
    public String greeting(@ModelAttribute InputForm inputForm,
            @RequestParam(name = "name", required = false, defaultValue = "World")
            String name, BindingResult result, 
            Model model) {
        LOGGER.info("test start");
        
        if (StringUtils.isNotEmpty(inputForm.getTextValue())) {
            
            InputCsvParam input = 
                    new InputCsvParam(
                            createCurrentTime(),inputForm.getTextValue(),3);
            testService.writeCsvSample(input);
        }
        model.addAttribute("name", name);
        List<TestCsvParam> list = testService.readCsvSample();
        model.addAttribute("inputText", inputForm.getTextValue());
        model.addAttribute("paramlist", list);

        List<InputCsvParam> list2  = testService.readCsvTest();
        model.addAttribute("testlist", list2);
        
        return "greeting";
    }
    
    private String createCurrentTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
