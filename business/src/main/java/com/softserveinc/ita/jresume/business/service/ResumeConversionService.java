package com.softserveinc.ita.jresume.business.service;

import com.softserveinc.ita.jresume.business.converter.ConverterException;

/**
 * Provides converting file with information about converted file.
 * 
 * @author Andriy Zykhor
 */
public interface ResumeConversionService {
    
    /**
     * Convert one format to another.
     * 
     * @param content
     *            array of bytes that contains content to format
     * @param fileName
     *            the name of the file which will be downloaded
     * @return {@link ConversionResult} that contains information about
     *         converted file
     * @throws ConverterException
     *             in case during conversion process
     */
    ConversionResult convert(byte[] content, final String fileName)
            throws ConverterException;
}
