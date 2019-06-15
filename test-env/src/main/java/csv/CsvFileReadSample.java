package csv;

import static constants.CsvConstants.CHARSET;
import static constants.CsvConstants.PATH;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CsvFileReadSample {

    /**
     * Csvからのデータ取得
     * 
     * @return 読み込んだCSVList
     */
    public List<String> getTestCsv(String fileName) {
        try {
            return Files.readAllLines(Paths.get(PATH + fileName),
                    Charset.forName(CHARSET));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
