package controller.webview;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import constants.LevelItem;
import constants.RadioItem;
import controller.BaseController;
import dto.InputCsvParam;
import form.SelectForm;
import presenter.QuestionsPresenter;

@Controller
public class WebViewController extends BaseController{

    @RequestMapping(value = "/select", method = { GET, POST })
    public String select(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model, HttpServletRequest request) {

        LOGGER.info("select view start");
        // TODO　選択画面を表示するのに必要な情報を整理
        // 特に問題種別やレベルの仕様は整理が必要
        model.addAttribute("selectForm", new SelectForm());
        model.addAttribute("name", name);
        model.addAttribute("radioItems", RadioItem.values());
        model.addAttribute("numbers", 29);
        // 増える要素はPresenterで別メソッド定義
        model.addAttribute("allLevels", LevelItem.values());
        return "select";
    }

    @RequestMapping(value = "/typing", method = { GET, POST })
    public String typing(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            @ModelAttribute SelectForm selectForm, BindingResult result,
            Model model) {
        LOGGER.info("typing view start");

        model.addAttribute("name", name);
        model.addAttribute("questionNumber",
                selectForm.getQuestionNumber() == null ? 10
                        : selectForm.getQuestionNumber());

        // Formの引数とあわせて問題を生成
        model.addAttribute("questionsPresenter", new QuestionsPresenter(
                testService.readCsvSample(), selectForm));

        return "typing";
    }

    @RequestMapping(value = "/history", method = { GET, POST })
    public String history(
            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        List<InputCsvParam> list2 = testService.readCsvTest();
        model.addAttribute("testlist", list2);

        return "history";
    }

}
