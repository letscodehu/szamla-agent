package hu.letscode.billing.domain;

/**
 * The response type of the API. It could be simple html or XML body.
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
