package com.softserveinc.ita.jresume.business.enums;

/**
 * Allowed file extensions for uploading files.
 * 
 * @author Golovii Sergii
 *         
 */
public enum FileExtensions {
    /**
     * Schema file format.
     */
    XSL,
    /**
     * Image file format.
     */
    PNG;
    
    /**
     * Returns enum's string value in lower case format.
     * 
     * @return string with enum's value in lower case.
     */
    public String toString() {
        return name().toLowerCase();
    }
}
