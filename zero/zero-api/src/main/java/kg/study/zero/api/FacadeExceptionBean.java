package kg.study.zero.api;

/**
 * Wrapper for saving {@link FacadeException} state when
 * transferring from web service endpoint. Needed by JAX-WS when
 * original exception class has additional fields (like <code>modifiers</code> for example)
 *
 * @author Konstantin_Grigoriev
 */
public class FacadeExceptionBean {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
