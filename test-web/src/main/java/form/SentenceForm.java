package form;

import java.io.Serializable;

import lombok.Data;

@Data
public class SentenceForm  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String word;
    private String answer;
}
