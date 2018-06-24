package billing.domain;

/**
 * Created by tacsiazuma on 2017.05.07..
 */
public enum Language {
    HU("hu"),DE("de"),EN("en"),IT("it"), RO("ro"), HR("hr"), FR("fr");

    private String value;

    Language(String value) {
        this.value = value;
    }
}
