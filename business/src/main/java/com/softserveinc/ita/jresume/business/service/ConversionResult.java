package com.softserveinc.ita.jresume.business.service;

/**
 * Converted file and information about it.
 * 
 * @author Andriy Zykhor
 */
public class ConversionResult {
    
    /** The array of bytes of the result. */
    private byte[] content;
    
    /** Type of the content. */
    private String contentType;
    
    /** Response header. */
    private String header;
    
    /** Length of the content. */
    private int contentLenght;
    
    /**
     * Gets the content of result.
     * 
     * @return the content of the file
     */
    public final byte[] getContent() {
        return content;
    }
    
    /**
     * Setting the bytes of result.
     * 
     * @param newContent
     *            the new content to set
     */
    public final void setContent(final byte[] newContent) {
        content = newContent;
    }
    
    /**
     * Gets the content type of result.
     * 
     * @return the contentType
     */
    public final String getContentType() {
        return contentType;
    }
    
    /**
     * Setting the type of result.
     * 
     * @param newContentType
     *            the contentType to set
     */
    public final void setContentType(final String newContentType) {
        contentType = newContentType;
    }
    
    /**
     * Gets the header.
     * 
     * @return the map of headers
     */
    public final String getHeader() {
        return header;
    }
    
    /**
     * Setting the header of result.
     * 
     * @param newHeader
     *            the header to set
     */
    public final void setHeader(final String newHeader) {
        header = newHeader;
    }
    
    /**
     * Gets the content length of result.
     * 
     * @return the contentLenght
     */
    public final int getContentLenght() {
        return contentLenght;
    }
    
    /**
     * Setting the lenght of result.
     * 
     * @param newContentLenght
     *            the contentLenght to set
     */
    public final void setContentLenght(final int newContentLenght) {
        contentLenght = newContentLenght;
    }
    
}
