package com.softserveinc.ita.jresume.business.executor;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softserveinc.ita.jresume.business.converter.ConverterException;
import com.softserveinc.ita.jresume.business.service.ConversionResult;
import com.softserveinc.ita.jresume.business.service.ResumeConversionService;

/**
 * Executor that executes converting resume from html representation to another.
 * 
 * @author Andriy Zykhor
 */
@Service
public class ResumeConversionExecutor {
    
    /** Map of conversion services where key is format. */
    @Resource(name = "conversionServices")
    private Map<String, ResumeConversionService> convertionServices;
    
    /**
     * Execute specific conversion.
     * 
     * @param conversionType
     *            type of conversion
     * @param resume
     *            array of bytes that contains html representation of resume
     * @param fileName
     *            the name of the file which will be downloaded
     * @return {@link ConversionResult}
     * @throws ConverterException
     *             in case during conversion process
     */
    public final ConversionResult execute(final String conversionType,
            final byte[] resume, final String fileName)
                    throws ConverterException {
        return convertionServices.get(conversionType).convert(resume, fileName);
    }
}
