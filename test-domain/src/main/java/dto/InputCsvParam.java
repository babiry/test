package dto;

import lombok.Value;

@Value
public class InputCsvParam {
    private String dateTime;
    private String textValue;
    private Integer count;
}
