package hu.letscode.billing.client;

/**
 * The different methods of the API.
 */
public enum XmlField {

    // @TODO implement the other methods
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
