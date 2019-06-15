package csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.stereotype.Component;
import static constants.CsvConstants.*;

@Component
public class CsvFileWriteSample {

    /**
     * Csvからのデータ取得
     * 
     * @return 読み込んだCSVList
     */
    public boolean writeCsv(String writeData) {
        try {

            File file = new File(PATH + TEST_CSV_FILE_NAME);
            if (checkBeforeWritefile(file)) {
                FileWriter filewriter = new FileWriter(file, true);

                filewriter.write(writeData + CRLF);

                filewriter.close();
            } else {
                System.out.println("ファイルに書き込めません");
            }
            return true;

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * StringのリストからTestCsvParamのリストへ変換
     * 
     * @return CSVのList
     */
    private static boolean checkBeforeWritefile(File file) {
        if (file.exists()) {
            if (file.isFile() && file.canWrite()) {
                return true;
            }
        }

        return false;
    }
}
