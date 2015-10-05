package com.softserveinc.ita.jresume.business.utils;

import java.io.File;

/**
 * 
 * Contains methods to operate with files.
 * 
 * @author Golovii Sergii
 *         
 */
public final class FileUtils {
    
    /**
     * private default constructor (this is utility class).
     */
    private FileUtils() {
    
    }
    
    /**
     * Gets the extension of a file.
     * 
     * This method returns the textual part of the filename after the last dot.
     * 
     * @param file
     *            filename the filename to retrieve the extension of.
     * @return extension of file or <strong>null</strong> in case of not
     *         existing extension.
     */
    public static String getExtension(final File file) {
        String fileName = file.getAbsolutePath();
        int i = fileName.lastIndexOf('.');
        if (i != -1) {
            return fileName.substring(i + 1);
        }
        return null;
    }
    
}
