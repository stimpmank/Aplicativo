package org.profamilia.registro.model.exception;

public class DAOException extends RuntimeException {
    private static final long serialVersionUID = 2394637209611900805L;

    public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }
}
