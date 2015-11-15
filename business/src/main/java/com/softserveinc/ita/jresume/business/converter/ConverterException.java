package com.softserveinc.ita.jresume.business.converter;

/**
 * Signals that an error of some sort occurred during convertion.
 * 
 * @author Andriy Zykhor
 */
public class ConverterException extends Exception {
    
    /**
     * Universal version identifier for {@link ConverterException} class.
     */
    private static final long serialVersionUID = -256988177249368485L;
    
    /**
     * Constructs an {@code ConverterException} with the specified detail
     * message.
     * 
     * @param message
     *            The detail message (which is saved for later retrieval by the
     *            {@link #getMessage()} method)
     */
    public ConverterException(final String message) {
        super(message);
    }
    
    /**
     * Constructs an {@code ConverterException} with the specified detail
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
    public ConverterException(final String message, final Throwable cause) {
        super(message, cause);
    }
    
    /**
     * Constructs an {@code ConverterException} with the specified cause.
     * 
     * @param cause
     *            The cause (which is saved for later retrieval by the
     *            {@link #getCause()} method). (A null value is permitted, and
     *            indicates that the cause is nonexistent or unknown.)
     * 
     */
    public ConverterException(final Throwable cause) {
        super(cause);
    }
}
