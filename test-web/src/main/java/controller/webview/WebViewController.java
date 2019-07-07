package controller.webview;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

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
public class WebViewController {

    @Autowired
    private TestService testService;

    private Logger LOGGER = LogManager.getLogger();

    @RequestMapping(value = "/typing", method = { GET, POST })
    public String typing(@ModelAttribute InputForm inputForm,
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            BindingResult result, Model model) {
        LOGGER.info("typing view start");

        model.addAttribute("name", name);
        List<TestCsvParam> list = testService.readCsvSample();
        model.addAttribute("paramlist", list);

        List<InputCsvParam> list2 = testService.readCsvTest();
        model.addAttribute("testlist", list2);

        return "typing";
    }

    @RequestMapping(value = "/history", method = { GET, POST })
    public String history(@ModelAttribute InputForm inputForm,
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            BindingResult result, Model model) {
        List<InputCsvParam> list2 = testService.readCsvTest();
        model.addAttribute("testlist", list2);

        return "history";
    }

}
