package hu.letscode.billing.client;

/**
 * The possible error codes of the API.
 */
public enum ErrorCode {

    INTERNAL_ERROR(1),
    LOGON_ERROR(3),
    SECRET_PASS_NEEDED(49),
    MISSING_XML(53),
    E_BILLING_NOT_ALLOWED(54),
    E_BILL_FAILED_TO_SIGN(55),
    NOTIFICATION_SEND_FAILED(56),
    MALFORMED_XML(57),
    LOG_OFF_IN_YOUR_BROWSER(135),
    NOT_ALLOWED(136),
    MALFORMED_ACCOUNT_NUMBER(202),
    NOT_ALLOWED_YET(250),
    NET_AMOUNT_MISMATCH(259),
    TAX_AMOUNT_MISMATCH(260),
    GROSS_AMOUNT_MISMATCH(261);

    private int code;

    ErrorCode(int code) {

        this.code = code;
    }

}
