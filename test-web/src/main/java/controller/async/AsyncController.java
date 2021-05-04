package controller.async;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import controller.BaseController;
import dto.InputCsvParam;
import dto.Sentence;
import dto.TestCsvParam;
import form.SelectForm;
import form.SentenceForm;
import response.CsvResponse;

@RestController
public class AsyncController extends BaseController {

    @RequestMapping(value = "/csvwirte", method = { GET, POST })
    public List<CsvResponse> csvwirte(@ModelAttribute SelectForm inputForm,
            BindingResult result, Model model) {
        LOGGER.info("csv write");

        if (CollectionUtils.isNotEmpty(inputForm.getLevels())) {
            InputCsvParam input = new InputCsvParam(createCurrentTime(),
                    inputForm.getLevels().get(0), 3);
            testService.writeCsvSample(input);
        }
        List<TestCsvParam> list = testService.readCsvSample();
        model.addAttribute("inputText", inputForm.getLevels().get(0));
        model.addAttribute("paramlist", list);

        List<InputCsvParam> list2 = testService.readCsvTest();
        model.addAttribute("testlist", list2);
        CsvResponse res = new CsvResponse();
        res.setValue("test");
        res.setCount(99);
        return Arrays.asList(res);
    }

    @PostMapping(value = "/update_sentence")
    @ResponseBody
    public boolean update(@RequestBody SentenceForm inputForm,
            BindingResult result, Model model) {
        LOGGER.info("update start");
        LOGGER.info("word"+inputForm.getWord() + ":answer"+inputForm.getAnswer());
        if (!StringUtils.hasText(inputForm.getWord())
                || !StringUtils.hasText(inputForm.getAnswer())) {
            return false;
        }
        if (!updateIfNeeded(inputForm)) {
            return false;
        }
        return testService.updateSentence( new Sentence(inputForm.getId(),inputForm.getWord(),inputForm.getAnswer()));
    }

    /**
     * 現在時刻の取得
     * 
     * @return ISOローカル日付および時間形式での現在時刻
     */
    private String createCurrentTime() {
        return LocalDateTime.now()
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    /**
     * 対象の文字列の更新要否チェック
     * 
     * @return 対象文字列
     */
    private boolean updateIfNeeded(SentenceForm inputForm) {
        Sentence sent = testService.getSentence(inputForm.getId());
        if (sent == null) {
            return false;
        }
        return !inputForm.getWord().equals(sent.getWord())
                || !inputForm.getAnswer().equals(sent.getAnswer());
    }
}
