package com.softserveinc.ita.jresume.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.business.converter.ConverterException;
import com.softserveinc.ita.jresume.business.converter.PDFConverter;

/**
 * 
 * @author Andriy Zykhor
 */
@Service("pdfConversionService")
public class PDFConversionService implements ResumeConversionService {
    
    /** Converter that converts from html code to PDF representation. */
    @Autowired
    private PDFConverter pdfConverter;
    
    @Override
    public final ConversionResult convert(final byte[] htmlContent,
            final String fileName) throws ConverterException {
        byte[] pdfContent = pdfConverter.convert(htmlContent);
        
        ConversionResult result = new ConversionResult();
        result.setContent(pdfContent);
        result.setContentLenght(pdfContent.length);
        result.setContentType("application/pdf");
        result.setHeader(String.format("inline; filename=\"" + fileName
                + ".pdf\""));
                
        return result;
    }
}
