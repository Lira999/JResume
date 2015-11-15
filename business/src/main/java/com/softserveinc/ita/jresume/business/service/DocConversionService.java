package com.softserveinc.ita.jresume.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.business.converter.ConverterException;
import com.softserveinc.ita.jresume.business.converter.DocConverter;

/**
 * 
 * @author Andriy Zykhor
 */
@Service("docConversionService")
public class DocConversionService implements ResumeConversionService {
    
    /** Converter that converts from html to document representation. */
    @Autowired
    private DocConverter docConverter;
    
    @Override
    public final ConversionResult convert(final byte[] htmlContent,
            final String fileName) throws ConverterException {
        byte[] pdfContent = docConverter.convert(htmlContent);
        
        ConversionResult result = new ConversionResult();
        result.setContent(pdfContent);
        result.setContentLenght(pdfContent.length);
        result.setContentType("application/msword");
        result.setHeader(String.format("inline; filename=\"" + fileName
                + ".doc\""));
                
        return result;
    }
}
