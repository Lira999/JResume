package com.softserveinc.ita.jresume.business.xslt;

/**
 * Signals that an error of some sort occurred during xslt transformation.
 * 
 * @author Golovii Sergii
 */
public class XstlTransformerException extends Exception {
    
    /**
     * universal version identifier for {@link XstlTransformerException} class.
     */
    private static final long serialVersionUID = 8745466860571861339L;
    
    /**
     * Constructs an {@code XstlTransformerException} with {@code null} as its
     * error detail message.
     */
    public XstlTransformerException() {
        
    }
    
    /**
     * Constructs an {@code XstlTransformerException} with the specified detail
     * message.
     * 
     * @param message
     *            The detail message (which is saved for later retrieval by the
     *            {@link #getMessage()} method)
     */
    public XstlTransformerException(final String message) {
        super(message);
    }
    
    /**
     * Constructs an {@code XstlTransformerException} with the specified detail
     * message and cause.
     * 
     * @param message
     *            The detail message (which is saved for later retrieval by the
     *            {@link #getMessage()} method)
     * 
     * @param cause
     *            The cause (which is saved for later retrieval by the
     *            {@link #getCause()} method). (A null value is permitted, and
     *            indicates that the cause is nonexistent or unknown.)
     * 
     */
    public XstlTransformerException(final String message,
            final Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs an {@code XstlTransformerException} with the specified cause.
     * 
     * @param cause
     *            The cause (which is saved for later retrieval by the
     *            {@link #getCause()} method). (A null value is permitted, and
     *            indicates that the cause is nonexistent or unknown.)
     */
    public XstlTransformerException(final Throwable cause) {
        super(cause);
    }
}
