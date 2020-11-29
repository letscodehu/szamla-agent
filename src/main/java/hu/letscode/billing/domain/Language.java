package hu.letscode.billing.domain;

/**
 * Possible languages of the bill's content.
 */
public enum Language {
    HU("hu"), DE("de"), EN("en"), IT("it"), RO("ro"), HR("hr"), FR("fr");

    private final String value;

    Language(String value) {
        this.value = value;
    }
}
