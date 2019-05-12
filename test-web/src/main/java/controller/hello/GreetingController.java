package controller.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dto.TestCsvParam;
import service.TestService;

@Controller
public class GreetingController {

    @Autowired
    private TestService testService;

    @RequestMapping("/greeting")
    public String greeting(
            @RequestParam(name = "name", required = false,
            defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);

        List<TestCsvParam> list = testService.sample();
        model.addAttribute("paramlist", list);
        return "greeting";
    }
}
