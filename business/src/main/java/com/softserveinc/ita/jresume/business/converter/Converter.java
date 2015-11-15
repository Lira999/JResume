package com.softserveinc.ita.jresume.business.converter;

/**
 * For converting from one format to another.
 * 
 * @author Andriy Zykhor
 */
public interface Converter {
    
    /**
     * The method converts one file to another.
     * 
     * @param bytes
     *            file to convert
     * @return converted file
     * @throws ConverterException
     *             in case during conversion process
     */
    byte[] convert(byte[] bytes) throws ConverterException;
    
}
