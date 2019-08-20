package hu.letscode.billing.domain.marshaller;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import hu.letscode.billing.domain.Language;

/**
 * Class for marshalling and unmarshalling {@link Language} to {@link String}.
 */
public class LanguageTypeAdapter extends XmlAdapter<String, Language> {
    @Override
    public Language unmarshal(String v) throws Exception {
        return Language.valueOf(v.toUpperCase());
    }

    @Override
    public String marshal(Language v) throws Exception {
        return v.name().toLowerCase();
    }
}
