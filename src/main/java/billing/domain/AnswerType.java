package billing.domain;

/**
 * Created by tacsiazuma on 2017.05.07..
 */
public enum AnswerType {
    SIMPLE("1"), XML("2");

    private String value;

    AnswerType(String s) {
        this.value = s;
    }

    public String getValue() {
        return value;
    }
}
