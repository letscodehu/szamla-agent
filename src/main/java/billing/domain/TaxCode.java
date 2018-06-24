package billing.domain;

/**
 * Created by tacsiazuma on 2017.05.07..
 */
public enum TaxCode {

    TAM("TAM"), AAM("AAM"), EU("EU"), EUK("EUK"), MAA("MAA"), FAFA("F.AFA"), KAFA("K.AFA"), ZERO("0"), FIVE("5"),
    SEVEN("7"), EIGHTTEEN("18"), NINETEEN("19"), TWENTY("20"), TWENTYFIVE("25"), TWENTYSEVEN("27");

    private String value;

    TaxCode(String s) {
        this.value = s;
    }
}
