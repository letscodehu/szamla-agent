package billing.client;

/**
 * Created by tacsiazuma on 2017.03.11..
 */
public enum XmlField {

    CREATE_BILL("action-xmlagentxmlfile"),
    STORNO_BILL("action-szamla_agent_st"),
    RECORDING_CREDITS("action-szamla_agent_kifiz"),
    PDF_QUERY("action-szamla_agent_pdf");

    private String name;

    XmlField(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
