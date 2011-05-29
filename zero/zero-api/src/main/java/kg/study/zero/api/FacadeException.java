package kg.study.zero.api;

/**
 * Base exception for Facade layer.
 *
 * @author Konstantin_Grigoriev
 */
public class FacadeException extends Exception {
    public FacadeException(String message) {
        super(message);
    }
}
