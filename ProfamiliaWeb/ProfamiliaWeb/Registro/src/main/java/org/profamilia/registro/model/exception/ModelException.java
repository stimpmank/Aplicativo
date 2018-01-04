package org.profamilia.registro.model.exception;

public class ModelException extends Exception {
    public ModelException(String msg) {
        super(msg);
    }

    public ModelException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
